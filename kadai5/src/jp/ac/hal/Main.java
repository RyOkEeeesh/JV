package jp.ac.hal;

import java.util.HashMap;
import java.util.Map;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

public class Main {
    public static void main(String[] args) throws Exception {
        Terminal terminal = TerminalBuilder.builder().system(true).build();
        terminal.enterRawMode();
        NonBlockingReader reader = terminal.reader();

        System.out.println(Theme.BOLD + "OXGame" + Theme.RESET);
        printMenu(true);

        while (true) {
            Keys read = readKey(reader);

            if (read == Keys.EXIT) {
                terminal.close();
                System.exit(0);
            }

            if (read == Keys.ARROW_UP) {
                GameStatus.selectedIdx = (GameStatus.selectedIdx - 1 + Constants.MENU_ITEMS.length) % Constants.MENU_ITEMS.length;
                printMenu(false);
            } else if (read == Keys.ARROW_DOWN) {
                GameStatus.selectedIdx = (GameStatus.selectedIdx + 1) % Constants.MENU_ITEMS.length;
                printMenu(false);
            } else if (read == Keys.NUM_1) {
                GameStatus.selectedIdx = 0;
                printMenu(false);
            } else if (read == Keys.NUM_2) {
                GameStatus.selectedIdx = 1;
                printMenu(false);
            } else if (read == Keys.ENTER) {
                break;
            }
        }

        if (GameStatus.selectedIdx == Constants.MENU_ITEMS.length - 1) {
            terminal.close();
            System.exit(0);
        }

        int menuLines = Constants.MENU_ITEMS.length + 1;
        for (int i = 0; i < menuLines; i++) {
            System.out.print("\033[1A");
            System.out.print("\033[K");
        }
        System.out.flush();
        GameStatus.selectedIdx = 0;
        printBoard(true);

        while (true) {
            Keys read = readKey(reader);

            if (read == Keys.EXIT) {
                terminal.close();
                System.exit(0);
            }

            if (read == Keys.ARROW_UP) {
                GameStatus.selectedIdx = (GameStatus.selectedIdx - 3 + Constants.MAX) % Constants.MAX;
            } else if (read == Keys.ARROW_DOWN) {
                GameStatus.selectedIdx = (GameStatus.selectedIdx + 3) % Constants.MAX;
            } else if (read == Keys.ARROW_LEFT) {
                GameStatus.selectedIdx = (GameStatus.selectedIdx - 1 + Constants.MAX) % Constants.MAX;
            } else if (read == Keys.ARROW_RIGHT) {
                GameStatus.selectedIdx = (GameStatus.selectedIdx + 1) % Constants.MAX;
            } else if (read != null && read.getCode() >= 49 && read.getCode() <= 57) {
                GameStatus.selectedIdx = read.getCode() - 49;
            } else if (read == Keys.UNDO) {
                if (GameStatus.turnCount > 0) {
                    GameStatus.turnCount--;
                    GameStatus.winMask = 0;
                }
            } else if (read == Keys.REDO) {
                if (GameStatus.turnCount < GameStatus.maxTurn) {
                    GameStatus.turnCount++;
                    GameStatus.winMask = 0;
                }
            } else if (read == Keys.ENTER) {
                if (GameStatus.lines[GameStatus.turnCount][GameStatus.selectedIdx] == null) {
                    int nextTurn = GameStatus.turnCount + 1;

                    System.arraycopy(GameStatus.lines[GameStatus.turnCount], 0, GameStatus.lines[nextTurn], 0, Constants.MAX);

                    GameStatus.lines[nextTurn][GameStatus.selectedIdx] = GameStatus.turnCount % 2 == 0;
                    GameStatus.turnCount++;
                    GameStatus.maxTurn = GameStatus.turnCount;

                    if (GameStatus.turnCount >= 5 && checkLine()) {
                        break;
                    }

                    if (GameStatus.turnCount == Constants.MAX) {
                        printBoard(false);
                        System.out.println(Theme.CYAN_BOLD + "引き分け" + Theme.RESET);
                        break;
                    }
                }
            }
            printBoard(false);
        }

        terminal.close();
    }

    private static class GameStatus {
        public static int selectedIdx = 0;
        public static Boolean[][] lines = new Boolean[Constants.MAX + 1][Constants.MAX];
        public static int turnCount = 0;
        public static int maxTurn = 0;
        public static int winMask = 0;
    }

    private enum Keys {
        ESC(27),
        BRACKET(91),
        ARROW_UP(65),
        ARROW_DOWN(66),
        ARROW_RIGHT(67),
        ARROW_LEFT(68),
        ENTER(10, 13),

        NUM_1(49),
        NUM_2(50),
        NUM_3(51),
        NUM_4(52),
        NUM_5(53),
        NUM_6(54),
        NUM_7(55),
        NUM_8(56),
        NUM_9(57),

        UNDO(117, 85),
        REDO(114, 82),

        EXIT(3);

        private final int[] codes;
        private static final Map<Integer, Keys> BY_CODE = new HashMap<>();
        static {
            for (Keys key : values()) {
                for (int code : key.codes) {
                    BY_CODE.put(code, key);
                }
            }
        }

        Keys(int... codes) { this.codes = codes; }

        public int getCode() { return this.codes[0]; }
        public static Keys fromCode(int code) { return BY_CODE.get(code); }
    }

    private static class Constants {
        public static final int MAX = 9;
        public static final int[] WIN_LINE = {
                0b111000000, 0b000111000, 0b000000111,
                0b100100100, 0b010010010, 0b001001001,
                0b100010001, 0b001010100
        };

        public static final String WT = "╭───┬───┬───╮";
        public static final String WM = "├───┼───┼───┤";
        public static final String WB = "╰───┴───┴───╯";
        public static final String H = "│";
        public static final String O = "○";
        public static final String X = "✕";

        public static final String[] MENU_ITEMS = {"Start", "Quit"};
    }

    private static class Theme {
        public static final String RESET = "\033[0m";
        public static final String CSI = "\033[K";
        public static final String GREEN_BOLD = "\033[1;32m";
        public static final String CYAN_BOLD = "\033[1;36m";
        public static final String BG_YELLOW = "\033[43m";
        public static final String BOLD = "\033[1m";
    }

    private static Keys readKey(NonBlockingReader reader) throws Exception {
        int raw = reader.read();
        Keys key = Keys.fromCode(raw);

        if (key == Keys.ESC) {
            int next1 = reader.read();
            if (Keys.fromCode(next1) == Keys.BRACKET) {
                int next2 = reader.read();
                return Keys.fromCode(next2);
            }
        }
        return key;
    }

    private static void printMenu(boolean isFirstTime) {
        if (!isFirstTime) {
            int linesToMoveUp = Constants.MENU_ITEMS.length + 1;
            System.out.print("\033[" + linesToMoveUp + "A");
        }

        System.out.println(Theme.CYAN_BOLD + " ─── MENU ─── " + Theme.RESET);

        for (int i = 0; i < Constants.MENU_ITEMS.length; i++) {
            if (i == GameStatus.selectedIdx) {
                System.out.println(Theme.GREEN_BOLD + " ▶ " + Constants.MENU_ITEMS[i] + Theme.RESET + Theme.CSI);
            } else {
                System.out.println("   " + Constants.MENU_ITEMS[i] + Theme.CSI);
            }
        }
        System.out.flush();
    }

    private static void printBoard(boolean isFirstTime) {
        if (!isFirstTime) { System.out.print("\033[" + 7 + "A"); }

        Boolean[] lines = GameStatus.lines[GameStatus.turnCount];

        System.out.println(Constants.WT);
        for (int i = 0; i < lines.length; i++) {
            if (i == 3 || i == 6) {
                System.out.println(Constants.WM);
            }
            System.out.print(Constants.H);

            boolean isWinCell = (GameStatus.winMask & (1 << (Constants.MAX - 1 - i))) != 0;

            if (isWinCell) {
                System.out.print(Theme.GREEN_BOLD + " ");
            } else if (i == GameStatus.selectedIdx) {
                System.out.print(Theme.BG_YELLOW + " ");
            } else {
                System.out.print(" ");
            }

            Boolean isO = lines[i];
            if (isO == null) {
                System.out.print(isFirstTime || GameStatus.turnCount == 0 ? i + 1 : " ");
            } else {
                System.out.print(isO ? Constants.O : Constants.X);
            }

            if (i == GameStatus.selectedIdx || isWinCell) {
                System.out.print(" " + Theme.RESET);
            } else {
                System.out.print(" ");
            }

            if ((i + 1) % 3 == 0) {
                System.out.println(Constants.H);
            }
        }
        System.out.println(Constants.WB);
        System.out.flush();
    }

    private static Boolean checkLine() {
        int[] bits = {0, 0};
        Boolean[] currentLines = GameStatus.lines[GameStatus.turnCount];

        for (int i = 0; i < currentLines.length; i++) {
            if (currentLines[i] == null) continue;
            bits[currentLines[i] ? 1 : 0] |= (1 << (Constants.MAX - 1 - i));
        }

        for (int mask : Constants.WIN_LINE) {
            Boolean win = null;
            if ((bits[1] & mask) == mask) {
                win = true;
            } else if ((bits[0] & mask) == mask) {
                win = false;
            }
            if (win != null) {
                GameStatus.winMask = mask;
                printBoard(false);
                System.out.println(Theme.GREEN_BOLD + "勝者: " + Theme.RESET + (win ? Constants.O : Constants.X));
                return true;
            }
        }
        return false;
    }
}
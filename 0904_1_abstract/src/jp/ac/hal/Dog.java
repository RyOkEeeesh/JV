package jp.ac.hal;

public class Dog extends Animal {

    @Override
    public void purr() {
        System.out.println("bow");
    }

    @Override
    protected void eatImpl() {
        System.out.println("バクバク");
    }
}

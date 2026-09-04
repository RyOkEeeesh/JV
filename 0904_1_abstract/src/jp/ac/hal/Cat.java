package jp.ac.hal;

public class Cat extends Animal {

    @Override
    public void purr() {
        System.out.println("meow");
    }

    @Override
    protected void eatImpl() {
        System.out.println("パクパク");
    }
}

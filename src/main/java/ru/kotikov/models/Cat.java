package ru.kotikov.models;

public class Cat extends Pet {
    public Cat(String name, String breed, String commands) {
        super(name, breed, commands);
    }

    @Override
    public void voice() {
        System.out.println("Meow!");
    }
}

package ru.kotikov.models;

public class Dog extends Pet {

    public Dog(String name, String breed, String commands) {
        super(name, breed, commands);
    }

    @Override
    public void voice() {
        System.out.println("Bark!");
    }
}

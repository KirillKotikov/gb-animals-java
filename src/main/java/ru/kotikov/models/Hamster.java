package ru.kotikov.models;

public class Hamster extends Pet{
    public Hamster(String name, String breed, String commands) {
        super(name, breed, commands);
    }

    @Override
    public void voice() {
        System.out.println("Squeak");
    }
}

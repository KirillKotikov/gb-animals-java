package ru.kotikov.models;

public class Camel extends PackAnimal {
    public Camel(String name, String breed, String commands, int loadCapacity) {
        super(name, breed, commands, loadCapacity);
    }

    @Override
    public void voice() {
        System.out.println("Brays!");
    }
}

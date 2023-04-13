package ru.kotikov.models;

public class Donkey extends PackAnimal{
    public Donkey(String name, String breed, String commands, int loadCapacity) {
        super(name, breed, commands, loadCapacity);
    }

    @Override
    public void voice() {
        System.out.println("Hee-haw!");
    }
}

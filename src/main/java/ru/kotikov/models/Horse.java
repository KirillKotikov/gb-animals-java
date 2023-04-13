package ru.kotikov.models;

public class Horse extends PackAnimal{
    public Horse(String name, String breed, String commands, int loadCapacity) {
        super(name, breed, commands, loadCapacity);
    }

    @Override
    public void voice() {
        System.out.println("Neigh!");
    }
}

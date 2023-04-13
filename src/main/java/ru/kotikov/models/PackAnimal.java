package ru.kotikov.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public abstract class PackAnimal extends Animal {

    protected List<String> commands;

    protected String name;

    protected int loadCapacity;


    public PackAnimal(String name, String breed, String commands, int loadCapacity) {
        this.name = name;
        this.breed = breed;
        this.commands = Arrays.stream(commands.split(", ")).collect(Collectors.toList());
        this.loadCapacity = loadCapacity;
    }

    public abstract void voice();

    public void addCommand(String command) {
        this.commands.add(command);
    }

    @Override
    public String toString() {
        return "Вьючное животное: " +
                "id = " + id +
                ", кличка = '" + name + '\'' +
                ", порода = '" + breed + '\'' +
                ", грузоподъёмность = " + loadCapacity +
                ", комманды = " + String.join(", ", commands);
    }
}

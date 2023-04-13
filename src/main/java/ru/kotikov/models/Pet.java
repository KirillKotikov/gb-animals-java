package ru.kotikov.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public abstract class Pet extends Animal {
    protected List<String> commands;

    protected String name;


    public Pet(String name, String breed, String commands) {
        this.breed = breed;
        this.name = name;
        this.commands = Arrays.stream(commands.split(", ")).collect(Collectors.toList());
    }

    public abstract void voice();

    public void addCommand(String command) {
        this.commands.add(command);
    }

    @Override
    public String toString() {
        return "Домашнее животное: " +
                "id = " + id +
                ", кличка = '" + name + '\'' +
                ", порода = '" + breed + '\'' +
                ", комманды = " + String.join(", ", commands);
    }
}

package ru.kotikov.models;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class Pet extends Animal {
    public Pet(Instant dateOfBirth, String name, String commands) {
        super(dateOfBirth, name, commands);
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    @Override
    public String toString() {
        return "Домашнее животное: " + super.toString();
    }
}

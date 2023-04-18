package ru.kotikov.models;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class PackAnimal extends Animal {

    public PackAnimal(Instant dateOfBirth, String name, String commands) {
        super(dateOfBirth, name, commands);
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    @Override
    public String toString() {
        return "Вьючное животное: " + super.toString();
    }
}

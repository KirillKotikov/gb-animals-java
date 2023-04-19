package ru.kotikov.models;

import java.time.Instant;

public class Donkey extends PackAnimal {
    public Donkey(Instant dateOfBirth, String name, String commands) {
        super(dateOfBirth, name, commands);
    }
}

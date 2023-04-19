package ru.kotikov.models;

import java.time.Instant;

public class Horse extends PackAnimal {
    public Horse(Instant dateOfBirth, String name, String commands) {
        super(dateOfBirth, name, commands);
    }
}

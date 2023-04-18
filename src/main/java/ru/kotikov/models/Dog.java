package ru.kotikov.models;

import java.time.Instant;

public class Dog extends Pet {
    public Dog(Instant dateOfBirth, String name, String commands) {
        super(dateOfBirth, name, commands);
    }
}

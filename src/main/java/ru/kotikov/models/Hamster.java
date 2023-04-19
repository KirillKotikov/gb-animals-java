package ru.kotikov.models;

import java.time.Instant;

public class Hamster extends Pet {
    public Hamster(Instant dateOfBirth, String name, String commands) {
        super(dateOfBirth, name, commands);
    }
}

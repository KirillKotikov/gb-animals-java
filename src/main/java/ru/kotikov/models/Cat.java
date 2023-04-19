package ru.kotikov.models;

import java.time.Instant;

public class Cat extends Pet {
    public Cat(Instant dateOfBirth, String name, String commands) {
        super(dateOfBirth, name, commands);
    }
}

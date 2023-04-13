package ru.kotikov.models;

import lombok.Getter;
import lombok.Setter;
import ru.kotikov.utils.Counter;

@Getter
public abstract class Animal {
    protected int id;
    protected @Setter String breed;

    public Animal() {
        this.id = Counter.add();
    }
}

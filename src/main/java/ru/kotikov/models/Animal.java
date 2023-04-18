package ru.kotikov.models;

import lombok.Getter;
import lombok.Setter;
import ru.kotikov.utils.Counter;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public abstract class Animal {
    protected int id;

    protected @Setter Instant dateOfBirth;

    protected @Setter String name;

    protected List<String> commands;

    public Animal(Instant dateOfBirth, String name, String commands) {
        this.id = Counter.add();
        this.dateOfBirth = dateOfBirth;
        this.name = name;
        this.commands = Arrays.stream(commands.split(", ")).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", кличка = '" + name + '\'' +
                ", дата рождения = " + dateOfBirth +
                ", комманды = " + String.join(", ", commands);
    }
}

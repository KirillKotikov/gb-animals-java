package ru.kotikov.repositories;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.kotikov.models.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class AnimalRepositoryImpl implements AnimalRepository {

    private final List<Animal> animals = new ArrayList<>();

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    {
        animals.addAll(List.of(
                        new Dog(Instant.parse("2023-01-15T18:35:24.00Z"), "Собака", "Сидеть, фас"),
                        new Cat(Instant.parse("2023-01-20T18:35:24.00Z"), "Кошка", "Кушать, лежать"),
                        new Hamster(Instant.parse("2023-01-21T18:35:24.00Z"), "Хомяк", "Быть хомяком"),
                        new Horse(Instant.parse("2023-01-12T18:35:24.00Z"), "Лошадь", "Галоп, стоять"),
                        new Camel(Instant.parse("2023-01-08T18:35:24.00Z"), "Верблюд", "Плевать"),
                        new Donkey(Instant.parse("2023-01-04T18:35:24.00Z"), "Осёл", "Идти")
                )
        );
    }
}

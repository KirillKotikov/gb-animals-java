package ru.kotikov.repositories;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.kotikov.models.*;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class AnimalRepositoryImpl implements AnimalRepository{

    private final List<Animal> animals = new ArrayList<>();

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    {
        animals.addAll(List.of(
            new Dog("Собака", "Собачья", "Сидеть, фас"),
            new Cat("Кошка", "Кошачья", "Кушать, лежать"),
            new Hamster("Хомяк", "Хомячья", "Быть хомяком"),
            new Horse("Лошадь", "Лошадинная", "Галоп, стоять", 200),
            new Camel("Верблюд", "Верблюжья", "Плевать", 150),
            new Donkey("Осёл", "Ослинная", "Идти", 100)
                )
        );
    }
}

package ru.kotikov.repositories;

import ru.kotikov.models.Animal;

import java.util.List;

public interface AnimalRepository {
    void addAnimal(Animal animal);
    List<Animal> getAnimals();
}

package ru.kotikov.services;

import ru.kotikov.models.Animal;

public interface AnimalService {
    String getAnimalCommands(Animal animal);

    void addCommandForAnimal(Animal animal, IOService ioService);
}

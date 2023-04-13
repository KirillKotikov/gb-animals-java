package ru.kotikov.services;

import org.springframework.stereotype.Service;
import ru.kotikov.models.Animal;
import ru.kotikov.models.PackAnimal;
import ru.kotikov.models.Pet;

import java.util.Optional;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Override
    public String getAnimalCommands(Animal animal) {
        String noCommands = "У животного нет комманд!";
        if (animal instanceof Pet pet) {
            Optional<String> commands = pet.getCommands().stream().reduce((x, y) -> x + ", " + y);
            return commands.orElse(noCommands);
        } else if (animal instanceof PackAnimal pet) {
            Optional<String> commands = pet.getCommands().stream().reduce((x, y) -> x + ", " + y);
            return commands.orElse(noCommands);
        } else {
            throw new RuntimeException("Not valid Animal!");
        }
    }

    @Override
    public void addCommandForAnimal(Animal animal, IOService ioService) {
        if (animal instanceof Pet pet) {
            pet.addCommand(ioService.readLineWithPrompt("Введите название комманды: "));
        } else if (animal instanceof PackAnimal pet) {
            pet.addCommand(ioService.readLineWithPrompt("Введите название комманды: "));
        } else {
            throw new RuntimeException("Not valid Animal!");
        }
    }
}

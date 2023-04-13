package ru.kotikov.services;

import org.springframework.stereotype.Service;
import ru.kotikov.models.*;
import ru.kotikov.repositories.AnimalRepository;

import java.util.Optional;

@Service
public class RegistryServiceImpl implements RegistryService {

    private final AnimalService animalService;

    private final AnimalRepository repository;

    private final IOService ioService;

    public RegistryServiceImpl(AnimalServiceImpl animalService, AnimalRepository repository,
                               IOService ioService) {
        this.animalService = animalService;
        this.repository = repository;
        this.ioService = ioService;
    }

    @Override
    public void start() {
        String MENU = """
                Добро пожаловать в реестр домашних животных
                1 - добавить животное
                2 - вывести список животных
                3 - отобразить список команд животного
                4 - добавить новую команду животному
                0 - выйти""";
        ioService.printLine(MENU);
        int option = ioService.readIntWithPrompt("Введите номер действия из меню: ");
        switch (option) {
            case -1 -> start();
            case 1 -> addAnimal();
            case 2 -> showAnimals();
            case 3 -> showAnimalCommands();
            case 4 -> addCommandForAnimal();
            case 0 -> exit();
            default -> {
                ioService.printLine("Вы ввели отсутствующий пункт меню!");
                start();
            }
        }

    }

    private void addCommandForAnimal() {
        int idFromUser = getIdFromUser();
        Optional<Animal> animalOptional = repository.getAnimals().stream().filter(x -> x.getId() == idFromUser)
                .findFirst();
        if (animalOptional.isPresent()) {
            animalService.addCommandForAnimal(animalOptional.get(), ioService);
        } else {
            ioService.printLine("Животного с таким id нет в регистре!");
        }
        start();
    }


    private int getIdFromUser() {
        return ioService.readIntWithPrompt("Введите id животного");
    }

    private void showAnimalCommands() {
        int idFromUser = getIdFromUser();
        Optional<Animal> animal = repository.getAnimals().stream().filter(x -> x.getId() == idFromUser).findFirst();
        if (animal.isPresent()) {
            ioService.printLine(animalService.getAnimalCommands(animal.get()));
        } else {
            ioService.printLine("Животного с таким id нет в регистре!");
        }
        start();
    }

    private void showAnimals() {
        for (Animal animal : repository.getAnimals()) {
            ioService.printLine(animal.toString());
        }
        start();
    }

    private void addAnimal() {
        int option = ioService.readIntWithPrompt("Если вы хотите добавить домашнее животное введите 1, " +
                "если вьючное, то введите 2. Вернуться в меню - 0: ");
        switch (option) {
            case 1 -> addPet();
            case 2 -> addPackAnimal();
            case 0 -> start();
            default -> {
                ioService.printLine("Вы ввели недействительный номер действия!");
                addAnimal();
            }
        }
        start();
    }

    private void addPackAnimal() {
        int option = ioService.readIntWithPrompt("""
                Введите номер животного, которое добавляем:
                1 - Лошадь
                2 - Верблюд
                3 - Осёл
                Вернуться в главное меню - 0:\s""");
        if (option > 0 && option < 4) {
            addPackAnimal(option);
        } else if (option == 0) {
            start();
        } else {
            ioService.printLine("Вы ввели недействительный номер действия!");
            addPet();
        }
    }

    private void addPackAnimal(int option) {
        try {
            String name = ioService.readLineWithPrompt("Введите кличку: ");
            String breed = ioService.readLineWithPrompt("Введите породу: ");
            String commands = ioService.readLineWithPrompt("Введите команды через запятую \",\" с пробелом после: ");
            int loadCapacity = 0;
            try {
                loadCapacity = Integer.parseInt(ioService
                        .readLineWithPrompt("Введите грузоподъёмность (целое число): "));
            } catch (NumberFormatException exception) {
                ioService.printLine("Вы ввели не число!");
                addPackAnimal();
            }
            switch (option) {
                case 1 -> repository.addAnimal(new Horse(name, breed, commands, loadCapacity));
                case 2 -> repository.addAnimal(new Camel(name, breed, commands, loadCapacity));
                case 3 -> repository.addAnimal(new Donkey(name, breed, commands, loadCapacity));
            }
        } catch (Exception exception) {
            throw new RuntimeException("Возникла ошибка при сохранении вьючного животного");
        }
    }

    private void addPet() {
        int option = ioService.readIntWithPrompt("""
                Введите номер животного, которое добавляем:
                1 - Собака
                2 - Кошка
                3 - Хомяк
                Вернуться в главное меню - 0:\s""");
        if (option > 0 && option < 4) {
            addPet(option);
        } else if (option == 0) {
            start();
        } else {
            ioService.printLine("Вы ввели недействительный номер действия!");
            addPet();
        }
    }

    private void addPet(int option) {
        try {
            String name = ioService.readLineWithPrompt("Введите кличку: ");
            String breed = ioService.readLineWithPrompt("Введите породу: ");
            String commands = ioService.readLineWithPrompt("Введите команды через запятую \",\" с пробелом после: ");
            switch (option) {
                case 1 -> repository.addAnimal(new Dog(name, breed, commands));
                case 2 -> repository.addAnimal(new Cat(name, breed, commands));
                case 3 -> repository.addAnimal(new Hamster(name, breed, commands));
            }
        } catch (Exception exception) {
            throw new RuntimeException("Возникла ошибка при сохранении домашнего животного");
        }
    }

    private void exit() {
        ioService.printLine("До свидания!");
        System.exit(0);
    }
}

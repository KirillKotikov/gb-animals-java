package ru.kotikov.services.processors;

public interface InputService {
    String readLineWithPrompt(String prompt);

    int readIntWithPrompt(String prompt);
}

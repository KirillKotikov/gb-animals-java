package ru.kotikov.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    public static AtomicInteger counter = new AtomicInteger(0);

    public static int add() {
        return counter.addAndGet(1);
    }
}

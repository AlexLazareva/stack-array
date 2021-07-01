package ru.interfaces;

import ru.beans.Process;

public interface ArrayStackInterface {
    void push(Process process);
    Process pop();
    Process peek();
    int size();
    boolean isEmpty();
    boolean isFull();
}

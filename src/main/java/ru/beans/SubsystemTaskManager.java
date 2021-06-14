package ru.beans;

import ru.interfaces.ArrayStackInterface;

import java.util.ArrayList;

public class SubsystemTaskManager<E> implements ArrayStackInterface<E> {
    private String systemType = null;
    private Process[] processes;
    private int head;
    private int maxSize;

    public SubsystemTaskManager (int capacity) {
        this.maxSize = capacity;
        processes = new Process[maxSize];
        head = -1;
        this.systemType = this.getSystemType();
    }

    private String getSystemType() {
        if (systemType == null) {
            systemType = System.getProperty("os.name");
        }
        return systemType;
    }

    @Override
    public void push(E e) {
        processes[++head] = (Process) e;
    }

    @Override
    public E pop() {
        return (E) processes[head--];
    }

    @Override
    public E peek() {
        return (E) processes[head];
    }

    @Override
    public int size() {
        return maxSize;
    }

    public int getHead() {
        return head;
    }

    @Override
    public boolean isEmpty() {
        return (head == -1);
    }

    @Override
    public boolean isFull() {
        return (head == maxSize - 1);
    }
}

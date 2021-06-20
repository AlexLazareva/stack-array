package ru.beans;

import ru.interfaces.ArrayStackInterface;

import java.util.ArrayList;

public class SubsystemTaskManager<E> implements ArrayStackInterface<E> {
    private String systemType = null;
    private StackArray processes;

    public SubsystemTaskManager () {
        processes = new StackArray(10);
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
        processes.push((Process) e);
    }

    @Override
    public E pop() {
        return (E) processes.pop();
    }

    @Override
    public E peek() {
        return (E) processes.peek();
    }

    @Override
    public int size() {
        return processes.size();
    }

    public int getHead() {
        return processes.getHead();
    }

    @Override
    public boolean isEmpty() {
        return processes.isEmpty();
    }

    @Override
    public boolean isFull() {
        return processes.isFull();
    }
}

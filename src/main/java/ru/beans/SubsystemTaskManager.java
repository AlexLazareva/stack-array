package ru.beans;

import ru.interfaces.ArrayStackInterface;

import java.util.ArrayList;

public class SubsystemTaskManager implements ArrayStackInterface {
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


    public void push(Process process) {
        processes.push((Process) process);
    }


    public Process pop() {
        return (Process) processes.pop();
    }

    @Override
    public Process peek() {
        return (Process) processes.peek();
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

package ru.beans;

public class StackArray {
    private int head;
    private int maxSize;
    private Process[] stackArray;

    public StackArray(int capacity) {
        this.maxSize = capacity;
        stackArray = new Process[maxSize];
        head = -1;
    }

    public void push(Process process) {
        stackArray[++head] = process;
    }

    public Process pop() {
        stackArray[head] = null;
        return stackArray[head--];
    }

    public Process peek() {
        return stackArray[head];
    }

    public int size() {
        return maxSize;
    }

    public int getHead() {
        return head;
    }

    public boolean isEmpty() {
        return (head == -1);
    }

    public boolean isFull() {
        return (head == maxSize - 1);
    }
}

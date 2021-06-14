package ru.interfaces;

public interface ArrayStackInterface<E> {
    void push(E e);
    E pop();
    E peek();
    int size();
    boolean isEmpty();
    boolean isFull();
}

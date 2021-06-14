package ru.beans;

public class Thread {
    private int id;
    private String state;

    public Thread(int id, String state) {
        this.id = id;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id; // Тело метода
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
} // Конец класса

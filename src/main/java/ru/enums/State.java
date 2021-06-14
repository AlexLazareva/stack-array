package ru.enums;

public enum State {
    NEW("new"),
    READY("ready"),
    RUNNING("running"),
    WAITING("waiting"),
    TERMINATED("terminated");

    private final String state;

    State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

package ru.enums;

public enum Status {
    SUCCESS("success"),
    STACK_ERROR("stack-error");

    private final String status;

    Status(String message) {
        this.status = message;
    }

    public String getStatus() {
        return status;
    }
}

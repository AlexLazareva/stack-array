package ru.enums;

public enum Page {
    INDEX_PAGE("/index.jsp"),
    SUBSYSTEM_TASK_MANAGER_PAGE("/views/taskManager.jsp"),
    PROCESS_PAGE("/views/process.jsp"),
    FULL_STACK_PAGE("/views/fullStack.jsp"),
    EMPTY_STACK_PAGE("/views/emptyStack.jsp");

    private final String page;

    Page(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }
}

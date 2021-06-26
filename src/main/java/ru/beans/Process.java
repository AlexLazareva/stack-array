package ru.beans;

public class Process {
    private int processId;
    private String name;
    private DynamicList threadList = new DynamicList();

    public Process(int processId, String name) {
        this.processId = processId;
        this.name = name;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DynamicList getThreadList() {
        return threadList;
    }

    public void addThread(Thread thread) {
        threadList.add(thread);
    }

    public void addThreadAsFirst(Thread thread) {
        System.out.println(thread);
    }

    public void addThreadAsLast(Thread thread) {
        System.out.println(thread);
    }

    public void removeThread(int id) {
        threadList.removeAt(id);
    }
}

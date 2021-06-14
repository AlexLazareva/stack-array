package ru.beans;

import java.util.LinkedList;

public class Process {
    private int processId;
    private String name;
    private LinkedList<Thread> threadLinkedList = new LinkedList<>();

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

    public LinkedList<Thread> getThreadLinkedList() {
        return threadLinkedList;
    }

    public void setThreadLinkedList(LinkedList<Thread> threadLinkedList) {
        this.threadLinkedList = threadLinkedList;
    }

    public int getThreadsListSize() {
        return threadLinkedList.size();
    }
    public void addThread(Thread thread) {
        threadLinkedList.add(thread);
    }

    public void addThreadByIndex(int index, Thread thread) {
        this.threadLinkedList.add(index, thread);
    }

    public void addThreadAsFirst(Thread thread) {
        threadLinkedList.addFirst(thread);
    }

    public void addThreadAsLast(Thread thread) {
        threadLinkedList.addLast(thread);
    }

    public void removeThread(int id) {
        this.threadLinkedList.remove(id);
    }
}

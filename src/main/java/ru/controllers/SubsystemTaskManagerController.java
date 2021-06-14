package ru.controllers;

import com.google.gson.Gson;
import ru.beans.Process;
import ru.beans.SubsystemTaskManager;

public class SubsystemTaskManagerController {
    private static SubsystemTaskManager<Object> subsystemTaskManager = new SubsystemTaskManager<>(10);

    public static String getSubsystemManager() {
        Gson gson = new Gson();
        return gson.toJson(subsystemTaskManager);
    }

    public static void push(String processName) {
        try {
            int processID = subsystemTaskManager.isEmpty() ? 0 : subsystemTaskManager.getHead();
            Process process = new Process(processID, processName);

            if (!subsystemTaskManager.isFull()) {
                subsystemTaskManager.push(process);
            }
        } catch (IndexOutOfBoundsException e) {
        }
    }

    public static Process peek() {
        return (Process) subsystemTaskManager.peek();
    }

    public static boolean isFull() {
        return subsystemTaskManager.isFull();
    }

    public static boolean isEmpty() {
        return subsystemTaskManager.isEmpty();
    }

    public static void popProcess() {
        subsystemTaskManager.pop();
    }
}

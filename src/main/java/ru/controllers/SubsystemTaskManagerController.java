package ru.controllers;

import com.google.gson.Gson;
import ru.beans.Process;
import ru.beans.SubsystemTaskManager;

public class SubsystemTaskManagerController {
    private static SubsystemTaskManager subsystemTaskManager = new SubsystemTaskManager();

    public static String getSubsystemManager() {
        Gson gson = new Gson();
        return gson.toJson(subsystemTaskManager);
    }

    public static void push(String processName) {
        try {
            int processID = subsystemTaskManager.getHead() + 1;
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

package ru.controllers;

import com.google.gson.Gson;
import ru.beans.Process;

public class ProcessController extends SubsystemTaskManagerController {
    private static final Process process = SubsystemTaskManagerController.peek();

    public static String getProcessJson() {
        Gson gson = new Gson();
        return gson.toJson(process);
    }

    public static int getThreadListSize() {
        return process.getThreadLinkedList().size() | 0;
    }
}

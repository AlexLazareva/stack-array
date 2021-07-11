package ru.servlets;

import com.google.gson.Gson;
import ru.beans.DynamicList;
import ru.beans.Process;
import ru.beans.Thread;
import ru.controllers.SubsystemTaskManagerController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(name = "upload", urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Process currentProcess = SubsystemTaskManagerController.peek();


        try (BufferedReader reader = Files.newBufferedReader(Paths.get(".../threads.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
            System.out.println(stringBuilder);
            Gson gson = new Gson();
            Process process = gson.fromJson(String.valueOf(stringBuilder), Process.class);
            DynamicList list = process.getThreadList();

            for (int i = 0; i < list.size(); i++) {
                currentProcess.addThread(list.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/process-page");
    }
}

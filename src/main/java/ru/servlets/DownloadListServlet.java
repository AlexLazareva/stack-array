package ru.servlets;

import com.google.gson.Gson;
import ru.beans.Process;
import ru.controllers.SubsystemTaskManagerController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "downloadList", urlPatterns = "/download")
public class DownloadListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Process data = SubsystemTaskManagerController.peek();
        OutputStream outputStream = null;
        Gson gson = new Gson();
        String listData = gson.toJson(data);

        try {
           outputStream = new FileOutputStream(new File("C:/Users/User/Desktop/threads.txt"));
           outputStream.write(listData.getBytes(StandardCharsets.UTF_8), 0, listData.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        response.sendRedirect(request.getContextPath() + "/process-page");
    }
}

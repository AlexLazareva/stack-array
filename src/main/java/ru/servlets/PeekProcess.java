package ru.servlets;

import com.google.gson.Gson;
import ru.beans.Process;
import ru.controllers.SubsystemTaskManagerController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "process", urlPatterns = "/peek-process")
public class PeekProcess extends HttpServlet {
    Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Process process = SubsystemTaskManagerController.peek();
        String processJson = gson.toJson(process);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(processJson);
        out.flush();
    }
}

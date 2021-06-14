package ru.servlets;

import ru.controllers.SubsystemTaskManagerController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "subsystemList", urlPatterns = "/subsystem-list")
public class SubsystemListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subsystemTaskManagerJson = SubsystemTaskManagerController.getSubsystemManager();

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(subsystemTaskManagerJson);
        out.flush();
    }
}

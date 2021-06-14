package ru.servlets;

import ru.beans.Process;
import ru.controllers.SubsystemTaskManagerController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "removeThread", urlPatterns = "/remove-thread")
public class RemoveThreadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int index = Integer.parseInt(request.getParameter("threadIndex"));
        Process process = SubsystemTaskManagerController.peek();

        process.removeThread(index);
        response.sendRedirect(request.getContextPath() + "/process-page");
    }
}

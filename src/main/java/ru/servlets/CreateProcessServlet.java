package ru.servlets;

import ru.controllers.SubsystemTaskManagerController;
import ru.enums.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createProcess", urlPatterns = "/add-process")
public class CreateProcessServlet extends HttpServlet {
    String page = Page.FULL_STACK_PAGE.getPage();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String processName = request.getParameter("processName");

        if (!SubsystemTaskManagerController.isFull()) {
            SubsystemTaskManagerController.push(processName);
            response.sendRedirect(request.getContextPath() + "/subsystem-task-manager");
        } else {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);
        }
    }
}

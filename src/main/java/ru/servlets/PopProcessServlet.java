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

@WebServlet(name = "popProcess", urlPatterns = "/pop-process")
public class PopProcessServlet extends HttpServlet {
    String page = Page.EMPTY_STACK_PAGE.getPage();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!SubsystemTaskManagerController.isEmpty()) {
            SubsystemTaskManagerController.popProcess();
            response.sendRedirect(request.getContextPath() + "/subsystem-task-manager");
        } else {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);
        }
    }
}

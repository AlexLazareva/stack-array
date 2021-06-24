package ru.servlets;

import ru.beans.Process;
import ru.beans.Thread;
import ru.controllers.ProcessController;
import ru.controllers.SubsystemTaskManagerController;
import ru.enums.Page;
import ru.enums.State;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addThread", urlPatterns = "/add-thread")
public class AddThreadServlet extends HttpServlet {
    private int initialID = 0;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addType = request.getParameter("threadAddType");
        Process process = SubsystemTaskManagerController.peek();
        int id  = process.getThreadList().size() > 0 ? process.getThreadList().size() : initialID;
        Thread thread = new Thread(id, State.NEW.getState());

        if (addType != null) {
            if (addType.equals("addFirst")) {
                process.addThreadAsFirst(thread);
            } else if (addType.equals("addLast")) {
                process.addThreadAsLast(thread);
            }
        } else {
            process.addThread(thread);
        }
        response.sendRedirect(request.getContextPath() + "/process-page");
    }
}

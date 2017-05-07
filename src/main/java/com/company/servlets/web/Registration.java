package com.company.servlets.web;

import com.company.servlets.logic.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class Registration extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controller server = new Controller(getServletContext()
                .getRealPath("/")
                .replace("target\\servlets-webapp\\", "src\\main\\resources"));
        server.register(request.getParameter("login"), 
                request.getParameter("password"));
        request.getRequestDispatcher("/user_page.jsp").forward(request, response);
    }
}

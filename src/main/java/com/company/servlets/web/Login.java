package com.company.servlets.web;

import com.company.servlets.logic.Controller;
import com.company.servlets.logic.content.Role;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Controller controller = new Controller(getServletContext()
                .getRealPath("/")
                .replace("target\\servlets-webapp\\", "src\\main\\resources"));
        Role role = controller.getUserRole(request.getParameter("parameter_lgn"),
                request.getParameter("parameter_pwd"));
        switch (role) {
            case ADMIN:
                response.sendRedirect("/jsp-webapp/admin_page");
                break;
            case USER:
                response.sendRedirect("/jsp-webapp/user_page");
                break;
            case NONREGISTERED:
                response.sendRedirect("/jsp-webapp/registration");
                break;
        }
    }
}

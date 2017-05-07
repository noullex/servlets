package com.company.servlets.logic;

import com.company.servlets.logic.content.Role;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/ServletFilter")
public class ServletFilter implements Filter {

    private FilterConfig filterConfig;
    private static ArrayList<String> pages;

    public ServletFilter() {
        if (pages == null) {
            pages = new ArrayList<String>();
        }
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        filterConfig = fConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String[] list = req.getRequestURI().split("/");
        String page = list[list.length - 1];
        if (page.equals("admin_page.jsp") || page.equals("admin_page")) {
            Role role = Controller.CURRENT_USER.getRole();
            switch (role) {
                case ADMIN:
                    filterChain.doFilter(request, response);
                    break;
                case USER:
                    req.getRequestDispatcher("/user_page.jsp").forward(request, response);
                    break;
                case NONREGISTERED:
                    req.getRequestDispatcher("/register.jsp").forward(request, response);
                    break;
            }
            return;
        }
        filterChain.doFilter(request, response);
    }
}

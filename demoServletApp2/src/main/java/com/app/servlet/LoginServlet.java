package com.app.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if("admin".equals(username) && "1234".equals(password)) {

            request.setAttribute("message", "Login Successful");

        } else {

            request.setAttribute("message", "Wrong Username or Password");

        }

        request.getRequestDispatcher("result.jsp")
               .forward(request,response);
    }
}
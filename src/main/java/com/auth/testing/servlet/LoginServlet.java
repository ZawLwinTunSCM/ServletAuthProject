package com.auth.testing.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.auth.testing.dao.UserDao;
import com.auth.testing.dao.UserDaoImpl;
import com.auth.testing.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final UserDao userDao;

    public LoginServlet() {
        super();
        this.userDao = new UserDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        User user = userDao.selectUser(email);
        if (user == null) {
            request.setAttribute("errorMsg", "User does not exist!");
            request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        } else {
            if (user.getPassword().equals(pass)) {
                String name = user.getName();
                HttpSession session = request.getSession();
                session.setAttribute("name", name);
                request.getRequestDispatcher("/jsp/success.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMsg", "Wrong Email or Password!");
                request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            }
        }
    }
}
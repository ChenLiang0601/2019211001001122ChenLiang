package com.ChenLiang.controller;

import com.ChenLiang.dao.UserDao;
import com.ChenLiang.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        con = (Connection)getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("./WEB-INF/views/updateUser.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        System.out.println(request.getParameter("birthday"));
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String password = request.getParameter("password");

        User user =new User();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setPassword(password);
        UserDao userDao = new UserDao();
        try {
            userDao.updateUser(con,user);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
//        request.setAttribute("user",user);
        HttpSession session = request.getSession(false);
        assert  session!=null;
        session.setAttribute("user",user);
        request.getRequestDispatcher("./WEB-INF/views/userinfo.jsp").forward(request,response);
    }

}


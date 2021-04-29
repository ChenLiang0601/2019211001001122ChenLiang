package com.ChenLiang.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name", value = "Chen Liang"),
                @WebInitParam(name="studentid", value = "2019211001001122"),
        }
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String name=config.getInitParameter("name"); //<param-name>name</param-name>
        String studentid=config.getInitParameter("studentid");
        PrintWriter writer = response.getWriter();
        writer.println("<br>name : "+name);
        writer.println("<br>studentid : "+studentid);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

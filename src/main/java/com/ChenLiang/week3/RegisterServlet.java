package com.ChenLiang.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet(
        name="x",
        urlPatterns = {"/register"},
        initParams = {
                @WebInitParam(
                        name="driver",
                        value="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                ),@WebInitParam(
                name="url",
                value="jdbc:sqlserver://localhost:1433;DatabaseName=userdb"
        ),
                @WebInitParam(
                        name="username",
                        value="CL"
                )  ,@WebInitParam(
                name="password",
                value="123456"
        )


        }
)
public class RegisterServlet extends HttpServlet {
    Connection con=null; //class variable
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
        //only one connection
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        //String username="sa";
        //String password="123456";
        //code like this is bad way --because change in not easy
        //for example change password of db = change in java code

        //get servletconfig --> getInitParameters --no change
        /*String driver=getInitParameter("driver");
        String url=getInitParameter("url");
        String username=getInitParameter("username");
        String password=getInitParameter("password");


        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con); //ok(use java code) -ok (use config in web.xml) -ok --use(@webservlet)
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// request come here
        //get parameter from request.
        PrintWriter writer = response.getWriter();
        String sql = "insert into [dbo].[user] values(?,?,?,?,?,?) ;";
        String id = request.getParameter("id");
        String username = request.getParameter("Username");//name of input type -<input type="text" name = "username"/><br/>
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        PreparedStatement pstmt = null; //调用javaSQL包的PreparedStatement来存储待运行的SQL语句
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, username);
            pstmt.setString(3, password);
            pstmt.setString(4, email);
            pstmt.setString(5, sex);
            pstmt.setString(6, birthday);


            pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("./login.jsp");
    }
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String username=request.getParameter("username");
//        String password=request.getParameter("password");
//        String email=request.getParameter("email");
//        String gender=request.getParameter("gender");
//        String BirthDate=request.getParameter("BirthDate");
//        PrintWriter writer= response.getWriter();
//        writer.println("<br>username:"+username);
//        writer.println("<br>password:"+password);
//        writer.println("<br>email:"+email);
//        writer.println("<br>gender:"+gender);
//        writer.println("<br>BirthDate:"+BirthDate);
//        writer.close();
//    }
    @Override
    public void destroy(){
        super.destroy();
        try {
            con.close(); //when tomcat stop
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
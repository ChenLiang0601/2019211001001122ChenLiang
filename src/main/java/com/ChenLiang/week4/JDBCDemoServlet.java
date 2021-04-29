package com.ChenLiang.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(
        urlPatterns = {"/jdbc"},
        initParams = {
                @WebInitParam(name="driver", value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url", value = "jdbc:sqlserver://localhost:1433;DatabaseName=userdb"),
                @WebInitParam(name="username", value = "CL" +
                        ""),
                @WebInitParam(name="password", value = "123456"),
        },loadOnStartup = 1
)//end of webservlet
 public class JDBCDemoServlet extends HttpServlet {
    Connection con=null; //class variable
    @Override
    public void init() throws ServletException{
        //only one connection
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
        //String username="CL";
        //String password="123456";
        //code like this is bad way --because change in not easy
        //for example change password of db = change in java code

        //get servletconfig --> getInitParameters --no change
        ServletConfig config = getServletConfig();
        String driver=config.getInitParameter("driver"); //<param-name>driver</param-name>
        String url=config.getInitParameter("url"); //<param-name>url</param-name>
        String username=config.getInitParameter("username"); //<param-name>username</param-name>
        String password=config.getInitParameter("password"); //<param-name>password</param-name>

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()-->"+con); //ok(use java code) -ok (use config in web.xml) -ok --use(@webservlet)
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Connection within do get -many times -bad way
        System.out.println("i am in doGet()");
        //we need to use con within doGet
        String sql="select * from user";
        try {
            ResultSet rs=con.createStatement().executeQuery(sql);
            while(rs.next()){
                //get from rs - print - write into response
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

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

//    <servlet>
//        <servlet-name>JDBCDemoServlet</servlet-name>
//        <servlet-class>com.XiaZikun.week4.demo.JDBCDemoServlet</servlet-class>
//        <!-- set in web.xml as config parameter -for only one servlet -JDBCDemoServlet-->
//        <!-- //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        //String url="jdbc:sqlserver://localhost:1433;DatabaseName=userdb";
//        //String username="CL";
//        //String password="123456";-->
//        <init-param>
//            <param-name>driver</param-name>
//            <param-value>com.microsoft.sqlserver.jdbc.SQLServerDriver</param-value>
//        </init-param>
//        <init-param>
//            <param-name>url</param-name>
//            <param-value>jdbc:sqlserver://localhost:1433;DatabaseName=userdb</param-value>
//        </init-param>
//        <init-param>
//            <param-name>username</param-name>
//            <param-value>sa</param-value>
//        </init-param>
//        <init-param>
//            <param-name>password</param-name>
//            <param-value>123456</param-value>
//        </init-param>
//        <load-on-startup>1</load-on-startup>
//        <!-- load and call init() when tomcat start -->
//    </servlet>
//    <servlet-mapping>
//        <servlet-name>JDBCDemoServlet</servlet-name>
//        <url-pattern>/jdbc</url-pattern><!-- write this url in action /-->
//    </servlet-mapping>



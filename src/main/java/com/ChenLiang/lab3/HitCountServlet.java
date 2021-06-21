package com.ChenLiang.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HitCountServlet" ,value="/HitCountServlet")
public class HitCountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer count=(Integer) getServletContext().getAttribute("count");
        if(count == null) {
            count=1;
        }else {
            count++;
        }
        getServletContext().setAttribute("count",count);
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>Total Number Of Hits</TITLE></HEAD>");
        out.println("  <BODY>");
        out.println("<center>");
        out.print("<h2>");
        out.print(" Total Number Of Hits<br> "+count);
        out.println("</h2>");
        out.println("</center>");
        out.println("  </BODY>");
        out.println("</HTML>");

    }
}

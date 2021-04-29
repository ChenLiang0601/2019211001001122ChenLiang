package com.ChenLiang;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class week2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        PrintWriter writer=response.getWriter();
        writer.println("Name:Chen Liang");
        writer.println("ID:2019211001001122");
        Date now =new Date();
        writer.println(now);


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}

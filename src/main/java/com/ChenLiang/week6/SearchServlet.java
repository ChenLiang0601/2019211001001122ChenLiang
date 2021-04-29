package com.ChenLiang.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException{
        String text=request.getParameter("txt");
        String s=request.getParameter("search");
        if(s.equals("baidu")){
            response.sendRedirect("https://www.baidu.com/s?wd="+text);}
        if(s.equals("bing")){
                response.sendRedirect("https://cn.bing.com/search?q="+text);}
        if(s.equals("sougou")){
                    response.sendRedirect("https://www.sogou.com/web?query="+text);

                }
    }
}



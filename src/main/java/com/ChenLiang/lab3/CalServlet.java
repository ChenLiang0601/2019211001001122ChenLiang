package com.ChenLiang.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name="CalServlet",value = "/CalServlet")
public class CalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstVal = request.getParameter("firstVal")!=null?request.getParameter("firstVal"):"";
        String secondVal = request.getParameter("secondVal")!=null?request.getParameter("secondVal"):"";
        String name = request.getParameter("name")!=null?request.getParameter("name"):"";
        String length=request.getParameter("length")!=null?request.getParameter("length"):"";
        String result=request.getParameter("result")!=null?request.getParameter("result"):"";
        System.out.println(firstVal);
        System.out.println(secondVal);
        System.out.println(name);
        Calculate calculate=new Calculate(Double.parseDouble(firstVal),Double.parseDouble(secondVal));
        if(request.getParameter("1")!=null) {
            Cookie cFirstValue=new Cookie("cFirstValue",firstVal);
            Cookie cSecondValue=new Cookie("cSecondValue",secondVal);
            Cookie cResult=new Cookie("cResult",calculate.add());
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
            System.out.println(1);
        }else if(request.getParameter("2")!=null) {
            Cookie cFirstValue=new Cookie("cFirstValue",firstVal);
            Cookie cSecondValue=new Cookie("cSecondValue",secondVal);
            Cookie cResult=new Cookie("cResult",calculate.subtract());
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
            System.out.println(2);
        }else if(request.getParameter("3")!=null) {
            Cookie cFirstValue=new Cookie("cFirstValue",firstVal);
            Cookie cSecondValue=new Cookie("cSecondValue",secondVal);
            Cookie cResult=new Cookie("cResult",calculate.multiply());
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
            System.out.println(3);
        }else if(request.getParameter("4")!=null) {
            Cookie cFirstValue=new Cookie("cFirstValue",firstVal);
            Cookie cSecondValue=new Cookie("cSecondValue",secondVal);
            Cookie cResult=new Cookie("cResult",calculate.divide());
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        }else if(request.getParameter("5")!=null) {
            Cookie cName=new Cookie("cName",name);
            Cookie cLength=new Cookie("cLength",""+name.length());
            response.addCookie(cName);
            response.addCookie(cLength);
        }else {
            System.out.println(6);
        }
        request.getRequestDispatcher("lab3/cal.jsp").forward(request,response);
    }
}

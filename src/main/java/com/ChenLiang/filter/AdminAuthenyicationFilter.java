package com.ChenLiang.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class AdminAuthenyicationFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException{
        HttpServletRequest httpRequest=(HttpServletRequest) request;
        HttpServletResponse httpResponse=(HttpServletResponse) response;
        HttpSession session=httpRequest.getSession(false);
        boolean isLoggedIn=(session !=null&&session.getAttribute("userList")!=null);
        String loginURI = httpRequest.getContextPath()+"/admin/login";
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage=httpRequest.getRequestURI().equals("login");
        if (isLoggedIn&&(isLoginRequest||isLoginPage)){
            RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/home");
            dispatcher.forward(request,response);
        }else if (isLoggedIn||isLoginRequest){
            chain.doFilter(request,response);
        }else{
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/admin/login");
        }
    }
    public void destory(){}
    public void init(FilterConfig filterConfig) throws ServletException{}
    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}

package com.ChenLiang.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class FrontEndAuthenticationFilter implements Filter {
    private HttpServletRequest httpRequest;
    private static final String[] loginRequiredURLs={
            "/updateUser","/login","/myCart"
    };

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
        httpRequest=(HttpServletRequest) request;
        String path=httpRequest.getRequestURI().substring(httpRequest.getContentLength());
        if (path.startsWith("/admin/")){
            chain.doFilter(request,response);
            return;
        }
        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn = (session !=null&&session.getAttribute("userList")!=null);
        String loginURI=httpRequest.getContextPath()+"/login";
        boolean isLoginRequest=httpRequest.getRequestURI().equals(loginURI);
        boolean isLoginPage=httpRequest.getRequestURI().endsWith("login");
        if (isLoggedIn&&(isLoginRequest||isLoginPage)){
            httpRequest.getRequestDispatcher("/").forward(request,response);
        }else if (!isLoggedIn&&isLoginRequired()){
            String loginPage="/login";
            RequestDispatcher dispatcher=httpRequest.getRequestDispatcher(loginPage);
            dispatcher.forward(request,response);
        }

    }

    private boolean isLoginRequired() {
        String requestURL=httpRequest.getRequestURI().toString();
        for (String loginRequiredURL:loginRequiredURLs){
            if (requestURL.contains(loginRequiredURL)){
                return true;
            }
        }return false;
    }
    public void destory(){}
    public void init(FilterConfig filterConfig) throws ServletException{}

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}

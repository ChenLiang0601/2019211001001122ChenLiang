package com.ChenLiang.lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


public class ChenLiangFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("ChenLiangFilter-->before chain");
        chain.doFilter(req, resp);
        System.out.println("ChenLiangFilter-->after chain");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

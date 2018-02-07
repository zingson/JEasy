package com.zingson.jeasy.core;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * JEasy framework filter
 */
public class JEasyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("** JEasyFilter.init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("** JEasyFilter.doFilter");
        //对拦截的请求，反射调用具体类

        //执行拦截器

        //执行AOP（全局与注解两种方式）

        //执行具体业务方法

    }

    @Override
    public void destroy() {
        System.out.println("** JEasyFilter.destroy");
    }
}

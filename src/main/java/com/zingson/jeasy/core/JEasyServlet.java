package com.zingson.jeasy.core;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JEasyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        String servletPath = req.getServletPath();

        //根据servletPath 调用Controller



        PrintWriter writer = resp.getWriter();
        writer.print("");
        writer.flush();
        writer.close();
    }
}

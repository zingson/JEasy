package com.zingson.jeasy.core.servlet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.easymock.EasyMock.*;


public class ExampleServletTest {

    @Before
    public void setUp(){

    }

    @After
    public void tearDown(){
    }


    @Test
    public void doGet() throws ServletException, IOException {
        System.out.println("service");

        HttpServletRequest request = createMock(HttpServletRequest.class);

        HttpServletResponse response = createMock(HttpServletResponse.class);

        //Creating the ServletConfig mock here

        ServletConfig servletConfig = createMock(ServletConfig.class);

        //Creating the ServletContext mock here

        ServletContext servletContext = createMock(ServletContext.class);

        //Create the target object

        ExampleServlet instance = new ExampleServlet();

        //初始化servlet,一般由容器承担，一般调用servletConfig作为参数初始化，此处模拟容器行为

        instance.init(servletConfig);

        //在某些方法被调用时设置期望的返回值，如下这样就不会去实际调用servletConfig的getServletContext方法，而是直接返回

        //servletContext,由于servletConfig是mock出来的，所以可以完全控制。

        expect(servletConfig.getServletContext()).andReturn(servletContext).anyTimes();

        expect(request.getParameter("username")).andReturn("testuser");

        PrintWriter pw=new PrintWriter(System.out,true);

        expect(response.getWriter()).andReturn(pw).anyTimes();

        //以上均是录制，下面为重放，该种机制为easymock测试机制，要理解请看easymock测试的一些资料
        replay(request);
        replay(response);
        replay(servletConfig);
        replay(servletContext);

        instance.doGet(request, response);

        pw.flush();


        //验证结果是否预期，如果预期，则会在pw上写出testuser.
        verify(request);
        verify(response);
        verify(servletConfig);
        verify(servletContext);
    }

    @Test
    public void doPost() {
    }

    @Test
    public void service() {
    }
}
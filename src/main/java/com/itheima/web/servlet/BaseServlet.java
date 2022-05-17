package com.itheima.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    //对HttpServlet里面的service方法重写，是的根据请求的方法名来处理不同的请求

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的方法名称
        String requestURI = req.getRequestURI();
        String methodName = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        //根据方法的名称执行对应的方法
        Class<? extends BaseServlet> cls = this.getClass();//this就指的是调用service方式的对象，即BrandServlet的实例对象
        try {
            //使用反射机制来执行对应的方法
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);//方法名和方法的参数类型的class
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

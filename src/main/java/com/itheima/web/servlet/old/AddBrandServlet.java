package com.itheima.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.imp.BrandServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addBrandServlet")
public class AddBrandServlet extends HttpServlet {
    BrandService service = new BrandServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的数据
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params,Brand.class);

        //调用service方法
        service.add(brand);
        //设置响应的字符串
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

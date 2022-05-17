package com.itheima.web.servlet.old;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.imp.BrandServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    //创建service对象
    private BrandService service = new BrandServiceImp();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service方法，查询数据
        List<Brand> brands = service.selectAll();
        //转换为json数据
        String jsonString = JSON.toJSONString(brands);
        //写入response
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

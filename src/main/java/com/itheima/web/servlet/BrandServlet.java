package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.service.imp.BrandServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    BrandService service = new BrandServiceImp();

    /**
     * 查询所有数据的方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //查询的逻辑
        List<Brand> brands = service.selectAll();
        //将对象转为json字符串
        String jsonString = JSON.toJSONString(brands);
        //将数据写入resp
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        //将字符串转换为对象
        Brand brand = JSON.parseObject(s, Brand.class);
        service.add(brand);
        //设置响应的字符串
        resp.getWriter().write("success");
    }

    public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        System.out.println("待查询的id=" + s);
        int id = Integer.parseInt(s);
        System.out.println("待查询的id=" + id);
        Brand brand = service.selectById(id);
        System.out.println(brand);
        String jsonString = JSON.toJSONString(brand);
        //将数据写入resp
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    public void updateBrand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        //将json字符串转换为对象
        Brand brand = JSON.parseObject(s, Brand.class);
        System.out.println(brand);
        service.updateBrand(brand);
        //设置响应字符串
        resp.getWriter().write("success");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        int id = Integer.parseInt(s);
        System.out.println("要删除的数据id="+id);
        service.delete(id);
        //设置响应参数
        resp.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        //将字符串转换为对象
        int[] ids= JSON.parseObject(s, int[].class);
        service.deleteByIds(ids);
        //设置响应参数
        resp.getWriter().write("success");
    }
}

package com.itheima.service.imp;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.service.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BrandServiceImp implements BrandService {
    @Autowired
    private BrandMapper mapper;

    @Override
    public List<Brand> selectAll() {

        List<Brand> brands = mapper.selectAll();
        //释放资源

        return brands;
    }

    @Override
    public void add(Brand brand) {
        //查询数据

        mapper.add(brand);
        //提交事务

    }

    @Override
    public Brand selectById(int id) {

        Brand brand = mapper.selectById(id);
        //释放资源

        return brand;
    }

    @Override
    public void updateBrand(Brand brand) {

        mapper.updateBrand(brand);
        //提交事务

        //关闭资源

    }

    @Override
    public void delete(int id) {

        mapper.delete(id);
        //提交事务

        //关闭资源

    }

    @Override
    public void deleteByIds(int[] ids) {

        mapper.deleteByIds(ids);
        //提交事务

        //关闭资源

    }


}

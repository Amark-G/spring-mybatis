package com.itheima.service;

import com.itheima.pojo.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {

    /**
     * 查询表tb_brand所有数据
     * @return
     */
    List<Brand> selectAll();

    /**
     * 向tb_brand表中添加一条数据
     * @param brand
     */
    void add(Brand brand);

    /**
     * 根据id查询单条数据
     * @param id
     * @return
     */
    Brand selectById(int id);

    /**
     * 根据id更新数据
     * @param brand
     */
    void updateBrand(Brand brand);

    /**
     * 根据id删除一条数据
     * @param id
     */
    void delete(int id);

    /**
     * 根据id数组批量删除
     * @param ids
     */
    void deleteByIds(int[] ids);
}

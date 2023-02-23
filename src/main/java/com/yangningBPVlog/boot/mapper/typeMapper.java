package com.yangningBPVlog.boot.mapper;

import com.yangningBPVlog.boot.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface typeMapper {
    //  新增分类
    void saveType(Type type);
    //  查询分类
    Type getType(@Param("id") Long id);

    //  查询所有分类列表
    List<Type> listType();
    //  修改分类标签
    void updateType(@Param("id") Long id,@Param("type") Type type);
    //删除分类
    void deleteType(@Param("id") Long id);
    //查询表中分类总数
    Long countType();

    //通过type_id查询博客数量
    Long queryBlogNumByTypeId(@Param("id") Long id);
}

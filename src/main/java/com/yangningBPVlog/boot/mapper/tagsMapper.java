package com.yangningBPVlog.boot.mapper;

import com.yangningBPVlog.boot.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: 阳寜
 * @Date: 2022-04-14
 */
@Mapper
public interface tagsMapper {

    //查询所有标签
    List<Tag> listTag();
    //通过tag_id查询博客数量
    Long queryBlogNumByTagId(@Param("id") Long id);
}

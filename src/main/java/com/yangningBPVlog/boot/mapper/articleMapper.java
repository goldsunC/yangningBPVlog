package com.yangningBPVlog.boot.mapper;

import com.yangningBPVlog.boot.entity.Blog;
import com.yangningBPVlog.boot.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: 阳寜
 * @Date: 2022-03-29
 */
@Mapper
public interface articleMapper {

    Blog queryBlogById(@Param("id") Long id);
    List<Tag> queryBlogTagById(@Param("id") Long id);

    //查询出数据库中所有文章
    List<Blog> queryAllBlogs();
    //查询出数据库中被推荐的文章的ID列表
    List<Long> queryRecommendBlogs();
}

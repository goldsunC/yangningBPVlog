package com.yangningBPVlog.boot.service;

import com.yangningBPVlog.boot.entity.Blog;
import com.yangningBPVlog.boot.mapper.articleMapper;
import com.yangningBPVlog.boot.util.MarkDownUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 阳寜
 * @Date: 2022-03-29
 */
@Slf4j
@Service
public class articleService {
    @Autowired
    articleMapper articleMapper;
    //增(发布一篇文章)

    //删(删除一篇文章)

    //改(更新一篇文章)

    //查(查询一篇文章)
    public Blog queryBlogById(Long id) {
        Blog blog = articleMapper.queryBlogById(id);
        blog.setTags(articleMapper.queryBlogTagById(id));
        log.info("当前博客的用户是："+blog.getUser());
//        处理content
        String content = blog.getContent();
        blog.setContent(MarkDownUtils.markDownToHtmlExtensions(content));

        return blog;
    }

    //查询到当前数据库所有文章
    public List<Blog> queryAllBlogs() {
        List<Blog> blogs = articleMapper.queryAllBlogs();
        return blogs;
    }


    //查询到数据库推荐的文章
    public List<Blog> queryRecommendBlogs() {
        List<Long> blogIdList = articleMapper.queryRecommendBlogs();
        List<Blog> blogList = new ArrayList<>();
        for (Long id : blogIdList) {
            blogList.add(articleMapper.queryBlogById(id));
        }
        return blogList;
    }

}

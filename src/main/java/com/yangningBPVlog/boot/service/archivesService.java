package com.yangningBPVlog.boot.service;

import com.yangningBPVlog.boot.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: 阳寜
 * @Date: 2022-04-14
 */

@Service
public class archivesService {
    @Autowired
    articleService articleService;
    public Map<String, List<Blog>> archiveBlog() {
        List<Blog> blogList = articleService.queryAllBlogs();
        Map<String,List<Blog>> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        for (Blog blog:blogList) {
            calendar.setTime(blog.getUpdateTime());
            String year = String.valueOf(calendar.get(Calendar.YEAR));
            if (map.get(year) != null) {
                map.get(year).add(blog);
            }else{
                map.put(year,new ArrayList<>());
                map.get(year).add(blog);
            }
        }
        return map;
    }
}

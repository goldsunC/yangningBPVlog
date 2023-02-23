package com.yangningBPVlog.boot.controller.blog;

import com.yangningBPVlog.boot.entity.Blog;
import com.yangningBPVlog.boot.service.articleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: 阳寜
 * @Date: 2022-03-29
 */
@Slf4j
@Controller
public class articleController {
    @Autowired
    articleService articleService;
    @GetMapping("/article/{id}")
    public String readArticle(@PathVariable Long id,
                              Model model) {
        Blog blog = articleService.queryBlogById(id);
        model.addAttribute("blog",blog);
        //log.info("查询到的博客为:" + blog);
        return "blog/article";
    }

}

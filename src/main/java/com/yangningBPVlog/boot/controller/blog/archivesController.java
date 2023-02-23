package com.yangningBPVlog.boot.controller.blog;

import com.yangningBPVlog.boot.entity.Blog;
import com.yangningBPVlog.boot.service.archivesService;
import com.yangningBPVlog.boot.service.articleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

/**
 * @author: 阳寜
 * @Date: 2022-04-14
 */

@Controller
@RequestMapping("/archive")
public class archivesController {
    @Autowired
    archivesService archivesService;
    @Autowired
    articleService articleService;
    @GetMapping
    public String archives(Model model) {

        Map<String, List<Blog>> archiveBlogMap = archivesService.archiveBlog();
        model.addAttribute("archiveBlogMap",archiveBlogMap);
        List<Blog> blogList = articleService.queryAllBlogs();
        model.addAttribute("blogNum",blogList.size());
        return "blog/archives";
    }
}

package com.yangningBPVlog.boot.controller.blog;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangningBPVlog.boot.entity.Blog;
import com.yangningBPVlog.boot.entity.Tag;
import com.yangningBPVlog.boot.entity.Type;
import com.yangningBPVlog.boot.service.articleService;
import com.yangningBPVlog.boot.service.tagsService;
import com.yangningBPVlog.boot.service.typeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 阳寜
 * @Date: 2022-03-29
 */

@Controller
public class homeController {
    @Autowired
    articleService articleService;
    @Autowired
    typeService typeService;
    @Autowired
    tagsService tagService;
    @GetMapping("/home")
    public String home(@RequestParam(value = "page",defaultValue = "1") Integer page,
                       @RequestParam(value = "limit",defaultValue = "5") Integer limit,
                       Model model) {
        PageHelper.startPage(page,limit);
        List<Blog> blogList = articleService.queryAllBlogs();
        PageInfo pageInfo = new PageInfo(blogList);
        model.addAttribute("pageInfoList",pageInfo);
        List<Type> typeList = typeService.listType();
        model.addAttribute("typeList",typeList);
        List<Tag> tagList = tagService.listTag();
        model.addAttribute("tagList",tagList);
        List<Blog> RecommendBlogs = articleService.queryRecommendBlogs();
        model.addAttribute("RecommendBlogs",RecommendBlogs);
        Map<Long,Long> BlogNumByType = new HashMap<>();
        for (Type type:typeList) {
            BlogNumByType.put(type.getId(),typeService.queryBlogNumByTypeId(type.getId()));
        }
        model.addAttribute("BlogNumByType",BlogNumByType);
        Map<Long,Long> BlogNumByTag = new HashMap<>();
        for (Tag tag:tagList) {
            BlogNumByTag.put(tag.getId(), tagService.queryBlogNumByTagId(tag.getId()));
        }
        model.addAttribute("BlogNumByTag",BlogNumByTag);
        return "blog/home";
    }
    @GetMapping("/yangning")
    public String yangning() {
        return "blog/aboutme";
    }
}

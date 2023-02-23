package com.yangningBPVlog.boot.controller.blog;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangningBPVlog.boot.entity.Blog;
import com.yangningBPVlog.boot.entity.Type;
import com.yangningBPVlog.boot.service.articleService;
import com.yangningBPVlog.boot.service.typeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 阳寜
 * @Date: 2022-04-01
 */
@Slf4j
@Controller
@RequestMapping("/types")
public class typeController {
    @Autowired
    typeService typeService;
    @Autowired
    articleService articleService;
    @GetMapping("/{id}")
    public String types(@RequestParam(value = "page",defaultValue = "1") Integer page,
                        @RequestParam(value = "limit",defaultValue = "3") Integer limit,
                        @PathVariable Long id, Model model) {

        List<Type> typeList = typeService.listType();
        PageHelper.startPage(page,limit);
        List<Blog> blogList = articleService.queryAllBlogs();
        PageInfo pageInfo = new PageInfo(blogList);
        model.addAttribute("pageInfoBlog",pageInfo);
        model.addAttribute("typeList",typeList);
//        log.info(typeList.toString());
        model.addAttribute("activeId",id);
        Map<Long,Long> BlogNumByType = new HashMap<>();
        for (Type type:typeList) {
            BlogNumByType.put(type.getId(),typeService.queryBlogNumByTypeId(type.getId()));
        }
        model.addAttribute("BlogNumByType",BlogNumByType);
        return "blog/types";
    }
}

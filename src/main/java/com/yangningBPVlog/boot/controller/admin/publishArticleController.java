package com.yangningBPVlog.boot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 阳寜
 * @Date: 2022-03-29
 */
@Controller
@RequestMapping("/admin")
public class publishArticleController {

    @GetMapping("/editArticle")
    public String publishArticle() {
        return "admin/editArticle";
    }
}

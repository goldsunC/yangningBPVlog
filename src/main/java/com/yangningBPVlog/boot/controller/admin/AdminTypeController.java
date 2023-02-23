package com.yangningBPVlog.boot.controller.admin;


import com.github.pagehelper.PageInfo;
import com.yangningBPVlog.boot.entity.Type;
import com.yangningBPVlog.boot.service.typeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 阳寜
 * @Date: 2022-03-30
 */

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminTypeController {

    @Autowired
    typeService typeService;
    //分类页面
    @GetMapping("/types")
    public String typeHomeShow(){

        return "admin/types";
    }


    /**
     * @Date:2022-03-31
     * @time:10:04
     * @author:阳寜
     * @explain:此一小段代码花费我大量心血耗费大量时间完成，仅此评论纪念一下
    * */
    @GetMapping("/returnjson")
    @ResponseBody
    public Map<String,Object> a(Integer page, Integer limit) throws JSONException {
        HashMap<String, Object> hashMap = new HashMap<>();
        //总列表
        List<Type> typeList = typeService.listType();
        //总列表的分页数据
        PageInfo<Type> typePageInfo = new PageInfo<>(typeList);
        hashMap.put("code",0);
        hashMap.put("msg","操作成功");
        hashMap.put("count",typePageInfo.getPageSize());
        //要展示的数据
        List<Type> data = typeService.listTypeByPageLimit(page, limit);
        hashMap.put("data",data);
        return hashMap;
    }

    //修改分类
    @GetMapping("/types/updateType")
    public String update(Long id,String name) {
        typeService.updateType(id,name);
        return "redirect:/admin/types";
    }



    //转到新增分类页面
    @GetMapping("/types/input")
    public String input() {
        return "admin/type-input";
    }


//  新增分类请求
    @PostMapping("/types/submit")
    public String typeSubmit(@Param("name") String name) {
        typeService.saveType(name);
        return "redirect:/admin/types";
    }

    //删除分类
    @GetMapping("/types/delete/{id}")
    public String inputType(@PathVariable("id") Long id) {
        log.info("现在要删除东西:"+id);
        typeService.deleteType(id);
        return "redirect:/admin/types";
    }

}

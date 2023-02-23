package com.yangningBPVlog.boot.service;

import com.yangningBPVlog.boot.entity.Tag;
import com.yangningBPVlog.boot.mapper.tagsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 阳寜
 * @Date: 2022-04-14
 */

@Service
public class tagsService {
    @Autowired
    tagsMapper tagMapper;
    public List<Tag> listTag(){
        return tagMapper.listTag();
    }

    public Long queryBlogNumByTagId(Long id) {
        return tagMapper.queryBlogNumByTagId(id);
    }
}

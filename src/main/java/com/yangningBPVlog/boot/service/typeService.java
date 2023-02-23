package com.yangningBPVlog.boot.service;

import com.yangningBPVlog.boot.entity.Type;
import com.yangningBPVlog.boot.mapper.typeMapper;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 阳寜
 * @Date: 2022-03-30
 */

@Service
public class typeService {

    @Autowired
    typeMapper typeMapper;
//  新增分类
    public void saveType(String name) {
        Long countNumber = typeMapper.countType();
        typeMapper.saveType(new Type(countNumber+1,name,null));
    }
//  根据ID查询类型
    public Type getType(Long id) {
        return typeMapper.getType(id);
    }
//  查询所有分类列表
    public List<Type> listType() {
        return typeMapper.listType();
    }
//  修改类型
    public void updateType(Long id,String name) {
        Type type1 = typeMapper.getType(id);
        if (type1 == null) {
            try {
                throw new NotFoundException("不存在该分类");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        typeMapper.updateType(id,new Type(id,name,null));
    }
//  删除分类
    public void deleteType(Long id) {
        typeMapper.deleteType(id);
    }

    //根据page和limit查询固定的数据
    public List<Type> listTypeByPageLimit(Integer page,Integer limit) {
        List<Type> typeList = typeMapper.listType();
        //处理最后一页
        if (page*limit < typeList.size()) {
            return typeList.subList((page - 1) * limit, page * limit);
        }else {
            return typeList.subList((page - 1) * limit, typeList.size());
        }
    }

    public Long queryBlogNumByTypeId(Long id) {
        return typeMapper.queryBlogNumByTypeId(id);
    }

}

package com.yangningBPVlog.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: 阳寜
 * @Date: 2022-03-28
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
////下面是jpa用于生成数据库表的注解
//@Entity(name = "t_blog")
//@Table
public class Blog {
//    @Id
//    @GeneratedValue
    private Long id;        //id主键
    private String title;       //题目
    private String content;     //正文
    private String summary;     //摘要
    private String firstPicture;    //图片
    private String flag;    //原创，转载，翻译
    private Integer views;  //浏览次数
    private boolean appreciation;   //赞赏是否开启
    private boolean shareStatement; //转载声明是否开启
    private boolean commentTabled;  //是否开启评论
    private boolean published;  //发布还是草稿
    private boolean recommend;  //是否推荐
//    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime; //创建时间
//    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;    //更新时间

//    @ManyToOne
    private Type type;      //每个博客有一个类型
//    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>(); //一篇博客很多标签
//    @ManyToOne
    private User user;  //一篇博客一个作者
//    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>(); //一篇博客多个评论
}

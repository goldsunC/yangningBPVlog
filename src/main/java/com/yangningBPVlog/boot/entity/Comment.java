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

//@Entity(name = "t_comment")
//@Table
public class Comment {
//    @Id
//    @GeneratedValue
    private Long id;
    private String nickName;
    private String email;
    private String content;
    private String avatar;  //头像
//    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;
//    @ManyToOne
    private Blog blog;  //一个评论对应一篇博客
//    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();    //每一个评论可能有多个回复
//    @ManyToOne
    private Comment parentComment;  //每条评论回复的对象只有一个
}

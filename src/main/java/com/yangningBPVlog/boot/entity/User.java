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

//@Entity(name = "t_user")
//@Table
public class User {
//    @Id
//    @GeneratedValue
    private Long id;
    private String nickName;
    private String userName;
    private String passWord;
    private String email;
    private String avatar;  //头像
    private Integer type;
//    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;
//    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
//    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();   //一个用户多篇博客
}

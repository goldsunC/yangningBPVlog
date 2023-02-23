package com.yangningBPVlog.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 阳寜
 * @Date: 2022-03-28
 */

@AllArgsConstructor
@NoArgsConstructor
@Data

//@Entity(name = "t_tag")
//@Table
public class Tag {
//    @Id
//    @GeneratedValue
    private Long id;
    private String name;
//    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();
}

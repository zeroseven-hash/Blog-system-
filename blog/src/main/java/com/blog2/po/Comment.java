package com.blog2.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="t_comment")
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String nickname;  //昵称
    private String email;   //邮箱
    private String content;  //评论内容
    private String avatar;  //头像
    private boolean adminComment; //是否是管理员
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;  //创建时间
    @ManyToOne
    private Blog blog;
    @OneToMany(cascade={CascadeType.REMOVE},mappedBy = "parentComment")
    private List<Comment> replyComments =new ArrayList<>();

    @ManyToOne
    private Comment parentComment;//父评论下可以有
    // 好几条子评论
}

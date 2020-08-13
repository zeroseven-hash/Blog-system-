package com.blog2.po;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Setter
//@Getter
@Data
@NoArgsConstructor
@Entity
@Table(name = "t_blog")
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String content;
    private String firstPicture;  //首图
    private String flag;   //标记
    private Integer view; //浏览次数
    private boolean appreciation; //赞赏是否开启
    private boolean shareStatement; //转载声明是否开启
    private boolean commentabled; //评论是否开启
    private boolean published; //是否发布
    private boolean recommend; //是否推荐；
    private String description;
    @Transient
    private String tagIds;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;  //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;   //更新时间
    @ManyToOne
    private Type type;  //分类。一个博客对应一个分类
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags=new ArrayList<>();
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments =new ArrayList<>();

    public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }

    //1,2,3
    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }

}

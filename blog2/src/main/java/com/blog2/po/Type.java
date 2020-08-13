package com.blog2.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_Type")
@Data
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message="分类名称不能为空")
    private String name;
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs =new ArrayList<>(); //一个分类可以有多个博客

}

package com.blog2.Controller;

import com.blog2.NotFoundExcepiton;
import com.blog2.po.Blog;
import com.blog2.service.BlogService;
import com.blog2.service.TagService;
import com.blog2.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @RequestMapping("/")
    public String index(@PageableDefault(size=4,sort={"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, Model model)  {
        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types",typeService.listTypeTop(6));
        model.addAttribute("tags",tagService.listTagTog(10));
        model.addAttribute("recommendblogs",blogService.listRecommendBlogTop(4));
        return "index";
    }


    @PostMapping("/search")
    public String search(@PageableDefault(size=8,sort={"updateTime"},direction = Sort.Direction.DESC) Pageable pageable, @RequestParam String query, Model model){

        model.addAttribute("page",blogService.listBlog(pageable,"%"+query+"%"));
        model.addAttribute("query",query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id,Model model){
        Blog b=blogService.getBlog(id);
        b.setView(b.getView()+1);
        blogService.updateBlog(id,b);
        model.addAttribute("blog",blogService.getAndConvert(id));
        return "blog";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/footer/newblog")
    public String newblogs(Model model){
        model.addAttribute("newblogs",blogService.listRecommendBlogTop(3));
        return "_fragment :: newblogList";
    }
}


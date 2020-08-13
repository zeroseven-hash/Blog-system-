package com.blog2.service;

import com.blog2.po.Blog;
import com.blog2.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {
    Blog getBlog (Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageabe);

    Page<Blog> listBlog(Pageable pageabe,String query);

    Page<Blog> listBlog(Pageable pageable,Long tagId);

    List<Blog> listRecommendBlogTop(Integer size);

    Map<String,List<Blog>> archivesBlog();
    Long countBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id,Blog blog);

    void deleteBlog(Long id);
}

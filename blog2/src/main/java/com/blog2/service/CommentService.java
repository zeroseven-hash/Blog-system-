package com.blog2.service;

import com.blog2.po.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment (Comment comment);

    void deleteComment(Long id);

    Comment getComment(Long id);
}

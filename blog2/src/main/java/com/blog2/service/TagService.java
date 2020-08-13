package com.blog2.service;

import com.blog2.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    Tag saveTag(Tag tag);
    Tag getTag(Long id);
    Page<Tag> listTag(Pageable pageable);
    void deleteTag(Long id);
    Tag updateTag(Long id,Tag tag);
    Tag getTagByName(String name);
    List<Tag> listTag();
    List<Tag> listTag(String ids);
    List <Tag> listTagTog(Integer size);
}

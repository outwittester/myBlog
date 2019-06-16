package com.sincere.service;

import com.sincere.dao.BlogDao;
import com.sincere.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override

    public Blog getBlog(Long id) {
        return null;
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable) {
        return null;
    }


    @Override
    public Blog addBlog(Blog blog) {
        return null;
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        return null;
    }

    @Override
    public void deleteBlog(Long id) {

    }
}

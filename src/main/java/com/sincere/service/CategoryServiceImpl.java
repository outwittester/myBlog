package com.sincere.service;

import com.sincere.dao.CategoryDao;
import com.sincere.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> listAllCategory() {
        return categoryDao.getCategoryList();
    }
}

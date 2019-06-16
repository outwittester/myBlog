package com.sincere.dao;

import com.sincere.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getCategoryList() {
        String sql = String.format("select * from categories");
//        RowMapper rowMapper = new TagMapper();
        List list = new ArrayList();
        try {
            list = jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            System.out.println("nothing get");
            e.printStackTrace();
        }

        return list;
    }
}

package com.sincere.dao;

import com.sincere.model.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserDao {
    User findByUsernameAndPassword(String username, String password);
}

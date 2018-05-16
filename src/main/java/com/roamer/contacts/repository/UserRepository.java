package com.roamer.contacts.repository;

import com.roamer.contacts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户数据处理层接口
 * @author roamer
 */
public interface UserRepository extends JpaRepository<User ,Long> {

    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    User findByUsername(String username);
}

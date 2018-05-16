package com.roamer.contacts.service;

import com.roamer.contacts.entity.User;

/**
 * 用户业务逻辑层接口
 * @author roamer
 */
public interface UserService {

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}

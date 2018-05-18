package com.roamer.contacts.controller;

import com.roamer.contacts.entity.User;
import com.roamer.contacts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户控制层
 *
 * @author roamer
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index")
    public String index() {
        return "user/index";
    }

    /**
     * 返回用户信息
     * produces属性关注请求的Accept头部信息
     * consumes属性关注请求的Content-Type头部信息
     * @param username
     * @return
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User show(@RequestParam(value = "username") String username) {
        return userService.findUserByUsername(username);
    }
}

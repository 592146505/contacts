package com.roamer.contacts.controller;

import com.roamer.contacts.entity.User;
import com.roamer.contacts.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 用户控制层
 *
 * @author roamer
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "user/index";
    }

    /**
     * 用户详情
     *
     * @param username
     * @param model
     * @return
     */
    @RequestMapping(value = "/detail/{username}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "username") String username, Model model) {
        User user = userService.findUserByUsername(username);
        if (null !=user){
            model.addAttribute(user);
        }
        return "user/detail";
    }

    /**
     * 返回用户信息
     * produces属性关注请求的Accept头部信息
     * consumes属性关注请求的Content-Type头部信息
     *
     * @param username
     * @return
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Cacheable(value = "user-key")
    public User show(@RequestParam(value = "username") String username) {
        return userService.findUserByUsername(username);
    }

    @RequestMapping(value = "/uid", method =RequestMethod.GET )
    @ResponseBody
    public String findUid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (null == uid) {
            uid = UUID.randomUUID();
            logger.info("session.id:[{}]", session.getId());
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}

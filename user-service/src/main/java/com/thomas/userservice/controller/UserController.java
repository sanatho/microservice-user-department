package com.thomas.userservice.controller;

import com.thomas.userservice.VO.RespondeTemplateVo;
import com.thomas.userservice.entity.User;
import com.thomas.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Saving user {}", user.toString());
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public RespondeTemplateVo getUserWithDepartment(@PathVariable("id") Long id){
        log.info("Searching for department for user with id {}", id);
        return userService.getUserWithDepartment(id);
    }
}

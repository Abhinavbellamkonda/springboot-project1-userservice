package com.codeswing.user.controller;

import com.codeswing.user.VO.ResponseTemplet;
import com.codeswing.user.entity.User;
import com.codeswing.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getbyid/{userId}")
    public ResponseTemplet getById(@PathVariable Long userId){
        return userService.getById(userId);
    }

}

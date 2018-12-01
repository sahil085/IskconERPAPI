package com.example.IskconErpAPI.controller;

import com.example.IskconErpAPI.co.UserInfoCO;
import com.example.IskconErpAPI.common.CommonResponseVO;
import com.example.IskconErpAPI.services.UserInfoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sahil on 1/12/18.
 */
@CrossOrigin
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    UserInfoServices userInfoServices;

    public static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @PostMapping("/createUser")
    public CommonResponseVO createUser(@Validated @RequestBody UserInfoCO userInfoCO) {
        return userInfoServices.createNewUser(userInfoCO);
    }

}

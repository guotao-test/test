package com.wfit.dachuang.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wfit.dachuang.pojo.User;
import com.wfit.dachuang.pojo.UserDetail;
import com.wfit.dachuang.service.RegisterService;
import com.wfit.dachuang.utils.CreateObjectNodeUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@CrossOrigin
@RestController
public class RegisterController {
    private static Logger logger=Logger.getLogger(RegisterController.class);

    @Autowired
    private RegisterService service;

    @RequestMapping("/register")
    public String register(@RequestBody UserDetail userDetail){
        String user_detail_id = UUID.randomUUID().toString().replaceAll("-", "");
        userDetail.setId(user_detail_id);
        String user_id = UUID.randomUUID().toString().replaceAll("-", "");
        userDetail.getUser().setId(user_id);
        ObjectNode node= CreateObjectNodeUtil.getObjectNode();
        if (service.register(userDetail)==2){
            logger.info("注册成功"+userDetail);
            return node.put("code","200").toString();
        }
        logger.error("注册失败");
        return node.put("code","500").toString();
    }
}

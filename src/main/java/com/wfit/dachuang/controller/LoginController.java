package com.wfit.dachuang.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wfit.dachuang.pojo.User;
import com.wfit.dachuang.service.LoginService;
import com.wfit.dachuang.utils.CreateObjectNodeUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class LoginController {
    private static Logger logger=Logger.getLogger(LoginController.class);

    @Autowired
    private LoginService service;

    @RequestMapping("login")
    public String login(@RequestBody User user){
        logger.info("用户账号尝试登录"+user.getAccount());
        int login = service.login(user);
        ObjectNode objectNode = CreateObjectNodeUtil.getObjectNode();
        if (login==0){
            logger.error(user.getAccount()+"查询失败");
            return objectNode.put("node","500").toString();
        }
        logger.info(user.getAccount()+"查询成功");
        return objectNode.put("node","200").toString();
    }
}

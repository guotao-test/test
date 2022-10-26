package com.wfit.dachuang.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.wfit.dachuang.pojo.User;
import com.wfit.dachuang.service.TestServiceImp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@Controller
public class TestController {
    private static Logger logger=Logger.getLogger(TestController.class);

    @Autowired
    private TestServiceImp testService;

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user) {
        int i = testService.checkUser(user);
        logger.info("account:"+user.getAccount()+"|pwd:"+user.getPwd()+"|role:"+user.getRole());
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode objectNode = mapper.createObjectNode();
        if (i==1){
            return objectNode.put("code",200).toString();
        }
         return objectNode.put("code",404).toString();
    }

}

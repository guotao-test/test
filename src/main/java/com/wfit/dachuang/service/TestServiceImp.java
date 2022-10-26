package com.wfit.dachuang.service;

import com.wfit.dachuang.mapper.TestMapper;
import com.wfit.dachuang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImp implements TestService  {
    @Resource
    private TestMapper mapper;

    @Override
    public int checkUser(User user) {
        return mapper.checkUser(user);
    }
}

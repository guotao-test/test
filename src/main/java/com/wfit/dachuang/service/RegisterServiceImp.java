package com.wfit.dachuang.service;

import com.wfit.dachuang.mapper.RegisterMapper;
import com.wfit.dachuang.pojo.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterServiceImp implements RegisterService{

    @Autowired
    private RegisterMapper mapper;
    //注册失败回滚
    @Transactional
    @Override
    public int register(UserDetail userDetail) {
        return mapper.registerUser(userDetail.getUser())+mapper.registerDetail(userDetail);
    }
}

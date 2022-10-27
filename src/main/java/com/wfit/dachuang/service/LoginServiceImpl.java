package com.wfit.dachuang.service;

import com.wfit.dachuang.mapper.LoginMapper;
import com.wfit.dachuang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper mapper;
    @Transactional
    @Override
    public int login(User user) {
        return mapper.login(user);
    }
}

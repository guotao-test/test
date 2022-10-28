package com.wfit.dachuang.service;

import com.wfit.dachuang.pojo.UserDetail;

public interface RegisterService {
    int register(UserDetail userDetail);
    int checkAccount(String account);
}

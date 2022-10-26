package com.wfit.dachuang.mapper;

import com.wfit.dachuang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface TestMapper {
    int checkUser(User user);
}

package com.wfit.dachuang.mapper;

import com.wfit.dachuang.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {
    int login(User user);
}

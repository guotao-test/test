package com.wfit.dachuang.mapper;

import com.wfit.dachuang.pojo.User;
import com.wfit.dachuang.pojo.UserDetail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RegisterMapper {
    int registerDetail(UserDetail userDetail);
    int registerUser(User user);
}

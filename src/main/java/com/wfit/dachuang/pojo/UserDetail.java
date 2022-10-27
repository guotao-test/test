package com.wfit.dachuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {
    private String id;
    private User user;
    private String email;
    private String phone;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String remarks;
    private String delFlag;

}

package com.wfit.dachuang.pojo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "account")
    private String account;
    @Column(name = "pwd")
    private String pwd;
    @JoinColumn(name = "user_detail_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //设置关联操作为ALL
    UserDetail detail;

}

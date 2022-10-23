package com.wfit.dachuang.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "userDetail")
public class UserDetail {
    @Column
    @Id
    String id;
}

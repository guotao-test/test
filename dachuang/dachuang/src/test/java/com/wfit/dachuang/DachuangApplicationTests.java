package com.wfit.dachuang;

import com.wfit.dachuang.pojo.User;
import com.wfit.dachuang.repository.UserRepository;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


@SpringBootTest
class DachuangApplicationTests {
    @Resource
    UserRepository repository;

    @Test
    void contextLoads() {
        System.out.println(repository.findById(1));
    }
    @Test
    void add(){
        User user=new User();
        user.setId(4);
        user.setAccount(UUID.randomUUID().toString().replaceAll("-",""));
        user.setPwd(UUID.randomUUID().toString());
        System.out.println(repository.save(user));
    }
    @Test
    void delete(){
        repository.deleteById(0);
    }
    @Test
    void  selectForPage(){
        Page<User> all1 = repository.findAll(PageRequest.of(0, 5));
        Iterator<User> iterator = all1.iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            System.out.println(next);
        }
    }
    @Test
    void tess(){
        List<User> userByAccountLike = repository.findUserByAccountLike("%%");
        System.out.println(userByAccountLike);
    }
    @Test
    void exist(){
        System.out.println(test);

    }
    @Value("${name}")
    String test;

}

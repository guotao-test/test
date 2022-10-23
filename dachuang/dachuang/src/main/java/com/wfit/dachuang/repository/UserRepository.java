package com.wfit.dachuang.repository;

import com.wfit.dachuang.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findUserByAccountLike(String account);
    boolean existsById(int id);
    @Transactional
    @Modifying
    @Query("update User set pwd=?2 where id=?1")
    int updatePasswordById(int id,String password);
}

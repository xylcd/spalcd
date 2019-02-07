package com.mindspa.spa.dao;


import com.mindspa.spa.pojo.SpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface userDao extends JpaRepository<SpaUser,Long> {
    /*
     * 根据用户名查询
     * */
    @Query(value = "select * from User  where user_name = ?1 AND password=?2",nativeQuery = true)
    SpaUser findByUserName(String name,String password);
}

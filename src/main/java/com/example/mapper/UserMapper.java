package com.example.mapper;

import com.example.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User getUserById(Integer id);

    List<User> getUserList();

    int add(User user);

    int update(@Param("id") Integer id, @Param("user") User user);

    int delete(Integer id);
}

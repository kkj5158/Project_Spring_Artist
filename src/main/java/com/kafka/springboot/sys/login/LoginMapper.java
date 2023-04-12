package com.kafka.springboot.sys.login;


import com.kafka.springboot.sqlmap.model.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginMapper {
    int insertuser(User user);

    int getId(User user);

    int getEmail(User user);
}

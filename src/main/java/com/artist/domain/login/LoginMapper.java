package com.artist.domain.login;


import com.artist.model.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginMapper {
    int insertuser(User user);

    int getIdcnt(User user);

    User getUserbyusername(String username);

    int getEmailcnt(User user);


}

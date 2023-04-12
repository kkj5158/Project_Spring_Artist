package com.kafka.springboot.sys.login;

import com.kafka.springboot.sqlmap.model.dto.User;

public interface LoginService {
    int register(User user);

}

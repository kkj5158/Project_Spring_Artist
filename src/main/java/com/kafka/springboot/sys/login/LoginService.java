package com.kafka.springboot.sys.login;

import com.kafka.springboot.sqlmap.model.dto.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    ResponseEntity register(User userdto);

    ResponseEntity login(User userdto, HttpServletResponse response);
}

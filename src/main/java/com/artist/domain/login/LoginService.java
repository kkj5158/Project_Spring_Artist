package com.artist.domain.login;

import com.artist.model.dto.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    void register(User userdto);
    void login(User userdto, HttpServletResponse response);
}

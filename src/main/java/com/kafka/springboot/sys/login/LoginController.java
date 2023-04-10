package com.kafka.springboot.sys.login;

import com.kafka.springboot.sqlmap.model.dto.artist;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LoginController {
    @GetMapping("/")
    public String main(ModelAndView mv, HttpServletRequest req) {
        return "login/login";
    }
}

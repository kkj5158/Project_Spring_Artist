package com.kafka.springboot.sys.login;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class LoginController {
    @GetMapping("/login")
    public ModelAndView main(ModelAndView mv, HttpServletRequest req) {
        mv.setViewName("login/login");

        return mv;
    }
}

package com.artist.domain.index;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class IndexController {
    @GetMapping("/")
    public ModelAndView main(ModelAndView mv, HttpServletRequest req) {
        mv.setViewName("index");

        return mv;
    }

    @GetMapping("/forbidden")
    public ModelAndView forbidden(ModelAndView mv, HttpServletRequest req) {
        mv.setViewName("forbidden");

        return mv;
    }
}

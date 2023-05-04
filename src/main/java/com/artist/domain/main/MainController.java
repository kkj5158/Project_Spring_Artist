package com.artist.domain.main;

import com.artist.model.dto.Artist;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainController {
    private final MainService mainService;

    @GetMapping("/main")
    public ModelAndView main(ModelAndView mv, HttpServletRequest req) {

        mv.setViewName("main/main");

        System.out.println("메인 컨트롤러 진입");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        List<Artist> artistList = mainService.getAllArtistinfo();

        mv.addObject("username", username);

        mv.addObject("artistList", artistList);

        return mv;

    }

    @GetMapping("/artists")
    public List<Artist> getArtists(HttpServletRequest req){
        List<Artist> artistList = mainService.getAllArtistinfo();

        return artistList;
    }



}

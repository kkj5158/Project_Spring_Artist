package com.kafka.springboot.sys.main;

import com.kafka.springboot.sqlmap.model.dto.Artist;
import com.kafka.springboot.sys.artisthome.ArtisthomeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ArtisthomeController {
    private final ArtisthomeService artisthomeService;
    @GetMapping("/artist")
    public ModelAndView main(ModelAndView mv, HttpServletRequest req) {

        System.out.println("아티스트홈 컨트롤러 진입");

        mv.setViewName("artisthome/artisthome");

        String artistid = req.getParameter("artist_id_num");

        int artist_id = Integer.parseInt(artistid);

        System.out.println(artist_id);

        Artist artistinfo = artisthomeService.getartistinfobyid(artist_id);


        mv.addObject("artistinfo", artistinfo);

        return mv;

    }

    @GetMapping("/artist/id")
    public Artist getArtistbyid(ModelAndView mv, HttpServletRequest req) {

        String artistid = req.getParameter("artist_id_num");
        int artist_id = Integer.parseInt(artistid);

        Artist artistinfo = artisthomeService.getartistinfobyid(artist_id);

        return artistinfo;

    }

}
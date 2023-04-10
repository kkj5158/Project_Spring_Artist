package com.kafka.springboot.sys.main;

import com.kafka.springboot.sqlmap.model.dto.Artist;

import java.util.List;


public interface MainService {

    public List<Artist> getAllArtistinfo();

}

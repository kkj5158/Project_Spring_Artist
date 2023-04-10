package com.kafka.springboot.sys.main;

import com.kafka.springboot.sqlmap.model.dto.artist;

import java.util.List;


public interface MainService {

    public List<artist> getAllArtistinfo();

}

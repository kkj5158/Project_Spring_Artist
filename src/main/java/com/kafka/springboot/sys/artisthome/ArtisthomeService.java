package com.kafka.springboot.sys.artisthome;

import com.kafka.springboot.sqlmap.model.dto.Artist;

import java.util.List;

public interface ArtisthomeService {

    public Artist getartistinfobyid(int artistid);

    public List<Artist> getAllArtistinfo();

}

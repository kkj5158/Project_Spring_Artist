package com.artist.domain.main;

import com.artist.model.dto.Artist;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MainMapper {
    List<Artist> getAllArtistinfo();
}

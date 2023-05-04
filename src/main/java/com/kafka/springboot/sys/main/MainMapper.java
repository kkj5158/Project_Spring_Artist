package com.kafka.springboot.sys.main;

import com.kafka.springboot.sqlmap.model.dto.Artist;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MainMapper {
    List<Artist> getAllArtistinfo();
}
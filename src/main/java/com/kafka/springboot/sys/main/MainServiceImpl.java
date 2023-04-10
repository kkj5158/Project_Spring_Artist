package com.kafka.springboot.sys.main;

import com.kafka.springboot.sqlmap.model.dto.Artist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    private final MainMapper mainMapper;

    @Override
    public List<Artist> getAllArtistinfo() {
        System.out.println("서비스 진입");

        return mainMapper.getAllArtistinfo();
    }
}

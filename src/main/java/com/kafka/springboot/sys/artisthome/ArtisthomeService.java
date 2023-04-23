package com.kafka.springboot.sys.artisthome;

import com.kafka.springboot.sqlmap.model.dto.Artist;
import com.kafka.springboot.sqlmap.model.dto.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArtisthomeService {

    public Artist getartistinfobyid(int artistid);

    public List<Artist> getAllArtistinfo();

    public List<Comment> getArtistComment(int artist_id);
    public Comment getIdComment(int id);

    public void createComment(Comment comment);

    public void modifyComment(Comment comment);
    public void deleteComment(int id);
}

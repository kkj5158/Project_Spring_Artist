package com.artist.model.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    private int id;
    private String comment;
    private int like_count;
    private Date created_at;
    private Date updated_at;
    private int user_id;
    private int artist_id;


    public Comment(int id, String comment, Date updated_at) {//댓글 수정을 위한 생성자
        this.id = id;
        this.comment = comment;
        this.updated_at = updated_at;
    }

}
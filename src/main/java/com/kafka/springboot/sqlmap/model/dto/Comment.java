package com.kafka.springboot.sqlmap.model.dto;
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
    private int like;
    private Date date;
    private int user_id;
    private int artist_id;
}
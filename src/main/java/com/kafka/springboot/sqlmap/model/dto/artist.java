package com.kafka.springboot.sqlmap.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class artist {
    private int id;
    private String name;
    private int fan_num;
    private int score;
    private String image_url;
    private int rank;
}
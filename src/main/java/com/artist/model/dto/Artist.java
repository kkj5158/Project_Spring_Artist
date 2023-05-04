package com.artist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artist {
    private int id;
    private String name;
    private int fan_num;
    private int score;
    private String ima_url;
    private int rank;
}

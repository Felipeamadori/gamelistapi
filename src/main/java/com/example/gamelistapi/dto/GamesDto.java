package com.example.gamelistapi.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GamesDto {
    private int id_game;
    private int appid;
    private String name;
    private String categ;
    private String genres;
    private String urlMedia;
    private int positive_rating;
    private int negative_rating;
    private String description;
}

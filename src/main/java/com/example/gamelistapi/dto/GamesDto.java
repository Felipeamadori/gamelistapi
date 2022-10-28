package com.example.gamelistapi.dto;

import com.example.gamelistapi.model.Games;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public GamesDto(Games game) {
        this.id_game = game.getId_game();
        this.appid = game.getAppid();
        this.name = game.getName();
        this.categ = game.getCateg();
        this.genres = game.getGenres();
        this.urlMedia = game.getUrlMedia();
        this.positive_rating = getPositive_rating();
        this.negative_rating = game.getNegative_rating();
        this.description = game.getDescription();
    }

    public static Page<GamesDto> toGamesDto(Page<Games> games) {
        return games.map(GamesDto::new);
    }
}

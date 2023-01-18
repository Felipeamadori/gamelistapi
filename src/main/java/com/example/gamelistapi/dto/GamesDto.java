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
    private Long id;
    private Long appid;
    private String name;
    private String categ;
    private String genres;
    private String urlMedia;
    private int positiveRating;
    private int negativeRating;
    private String description;
    private String shortDescription;

    public GamesDto(Games game) {
        this.id = game.getId();
        this.appid = game.getAppid();
        this.name = game.getName();
        this.categ = game.getCateg();
        this.genres = game.getGenres();
        this.urlMedia = game.getUrlMedia();
        this.positiveRating = game.getPositiveRating();
        this.negativeRating = game.getNegativeRating();
        this.description = game.getDescription();
        this.shortDescription = game.getShortDescription();
    }

    public static Page<GamesDto> toGamesDto(Page<Games> games) {
        return games.map(GamesDto::new);
    }
}

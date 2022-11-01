package com.example.gamelistapi.model;

import com.example.gamelistapi.dto.GamesDto;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "games")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Games {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long appid;
    @Column(columnDefinition = "TEXT")
    private String name;
    @Column(columnDefinition = "TEXT")
    private String categ;
    @Column(columnDefinition = "TEXT")
    private String genres;
    @Column(columnDefinition = "TEXT")
    private String urlMedia;
    private int positiveRating;
    private int negativeRating;
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String shortDescription;

    @OneToMany(mappedBy = "usuario")
    Set<UsuarioGames> usuarioGames;

    public GamesDto toGamesDto() {
        return new GamesDto(id,appid,name,categ,genres,urlMedia,positiveRating,negativeRating,description);
    }
}

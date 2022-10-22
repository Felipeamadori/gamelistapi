package com.example.gamelistapi.model;

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
    private int id_game;
    private int appid;
    private String name;
    private String categ;
    private String genres;
    private String urlMedia;
    private int positive_rating;
    private int negative_rating;
    private String description;

    @OneToMany(mappedBy = "usuario")
    Set<UsuarioGames> usuarioGames;
}

package com.example.gamelistapi.model;

import lombok.*;

import javax.persistence.*;

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
    private String name;
    private String categ;
    private String genres;
    private String urlMedia;
}

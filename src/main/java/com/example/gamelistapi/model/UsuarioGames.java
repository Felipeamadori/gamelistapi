package com.example.gamelistapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "usuario_games")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioGames {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario_games;
    private int id_usuario;
    private int id_game;
}

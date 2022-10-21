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
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_game")
    private Games game;
    private int nota;
    private String comentario;
}

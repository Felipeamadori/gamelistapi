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
    private int id;
    @ManyToOne
    @JoinColumn(name = "usuario.id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "game.id")
    private Games game;
    private int nota;
    private String comentario;
}

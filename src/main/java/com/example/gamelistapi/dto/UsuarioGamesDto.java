package com.example.gamelistapi.dto;

import com.example.gamelistapi.model.Games;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioGamesDto {
    private Long id;
    private Games game;
    private UsuarioDto usuario;
    private int nota;
    private String comentario;
}

package com.example.gamelistapi.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioGamesDto {
    private Long id;
    private Long idGame;
    private Long idUser;
    private int nota;
    private String comentario;
}

package com.example.gamelistapi.dto;

import lombok.*;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private int id_usuario;
    private String nome;
    private String email;
    private String datanasc;
}

package com.example.gamelistapi.dto;

import com.example.gamelistapi.model.Usuario;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;
    private String datanasc;
}

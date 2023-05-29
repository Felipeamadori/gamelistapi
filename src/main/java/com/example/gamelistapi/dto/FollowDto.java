package com.example.gamelistapi.dto;

import lombok.*;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowDto {
    private Long id;
    private UsuarioDto following;
    private UsuarioDto followe;
}



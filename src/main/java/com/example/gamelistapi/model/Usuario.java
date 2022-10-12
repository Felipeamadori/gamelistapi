package com.example.gamelistapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String nome;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    private String email;
    private String datanasc;
}

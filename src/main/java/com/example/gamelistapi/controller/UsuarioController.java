package com.example.gamelistapi.controller;

import com.example.gamelistapi.dto.UsuarioDto;
import com.example.gamelistapi.model.Usuario;
import com.example.gamelistapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping
    public String Hello() {
        return "Hello";
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> createUser(@Valid @RequestBody Usuario usuario, UriComponentsBuilder uriBuilder) throws Exception {
        try {
            Usuario u = usuarioService.createUser(usuario);
            u.setSenha(null);
            URI uri = uriBuilder.path("usuario/{id}").buildAndExpand(u.getId_usuario()).toUri();
            return ResponseEntity.created(uri).body(u);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}

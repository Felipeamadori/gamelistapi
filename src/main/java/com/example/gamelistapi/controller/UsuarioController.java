package com.example.gamelistapi.controller;

import com.example.gamelistapi.dto.UsuarioDto;
import com.example.gamelistapi.model.Usuario;
import com.example.gamelistapi.model.UsuarioGames;
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
    @Autowired

    @GetMapping
    public String Hello() {
        return "Hello";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDto> createUser(@Valid @RequestBody Usuario usuario, UriComponentsBuilder uriBuilder) throws Exception {
        try {
            UsuarioDto u = usuarioService.createUser(usuario).toUsuarioDto();
            URI uri = uriBuilder.path("usuario/{id}").buildAndExpand(u.getId_usuario()).toUri();
            return ResponseEntity.created(uri).body(u);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/adicionar-game")
    public ResponseEntity<UsuarioGames> addGame(@RequestBody UsuarioGames usuarioGames, UriComponentsBuilder uriBuilder) throws Exception {
        try {
            UsuarioGames u = usuarioService.addGame(usuarioGames);
            return ResponseEntity.ok().body(u);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}

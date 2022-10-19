package com.example.gamelistapi.service;

import com.example.gamelistapi.model.Usuario;
import com.example.gamelistapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();

    public Usuario createUser(Usuario usuario) throws Exception {
        try {
            usuario.setSenha(passEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

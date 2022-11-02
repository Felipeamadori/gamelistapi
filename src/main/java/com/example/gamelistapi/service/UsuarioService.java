package com.example.gamelistapi.service;

import com.example.gamelistapi.dto.GamesDto;
import com.example.gamelistapi.dto.UsuarioDto;
import com.example.gamelistapi.model.Games;
import com.example.gamelistapi.model.Usuario;
import com.example.gamelistapi.model.UsuarioGames;
import com.example.gamelistapi.repository.GamesRepository;
import com.example.gamelistapi.repository.UsuarioGamesRepository;
import com.example.gamelistapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioGamesRepository usuarioGamesRepository;
    @Autowired
    private GamesRepository gamesRepository;
    BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();

    @Transactional
    public Usuario createUser(Usuario usuario) throws Exception {
        try {
            usuario.setSenha(passEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public UsuarioGames addGame(UsuarioGames ug) throws Exception{
        try {
            return usuarioGamesRepository.save(ug);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public UsuarioDto getById(Long id) throws Exception{
        try {
            return usuarioRepository.findById(id).get().toUsuarioDto();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<GamesDto> getAllGamesByUserId(Long id) throws Exception {
        try {
            List<Long> ids = usuarioGamesRepository.findAllByUserId(id);
            List<GamesDto> games = new ArrayList<>();
            ids.forEach(idGame -> games.add(gamesRepository.findById(idGame).get().toGamesDto()));
            return games;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

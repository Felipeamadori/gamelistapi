package com.example.gamelistapi.service;

import com.example.gamelistapi.dto.GamesDto;
import com.example.gamelistapi.dto.UsuarioGamesDto;
import com.example.gamelistapi.model.Games;
import com.example.gamelistapi.repository.GamesRepository;
import com.example.gamelistapi.repository.UsuarioGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GamesService {
    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private UsuarioGamesRepository usuarioGamesRepository;

    @Transactional
    public GamesDto getById(Long id) throws Exception{
        try {
            return gamesRepository.findById(id).get().toGamesDto();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<GamesDto> getByName(String name) throws Exception {
        try {
            return gamesRepository.findGamesByName(name).stream().map(Games::toGamesDto).collect(Collectors.toList());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<UsuarioGamesDto> getAllReviewsByGameId(Long id) throws Exception {
        try {
            Games game = gamesRepository.findById(id).get();
            List<UsuarioGamesDto> reviews = new ArrayList<>();
            usuarioGamesRepository.findUsuarioGamesByGame(game)
                    .forEach(usuarioGames -> reviews.add(usuarioGames.toUsuarioGamesDto()));
            return reviews;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

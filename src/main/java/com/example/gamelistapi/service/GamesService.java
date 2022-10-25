package com.example.gamelistapi.service;

import com.example.gamelistapi.dto.GamesDto;
import com.example.gamelistapi.model.Games;
import com.example.gamelistapi.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GamesService {
    @Autowired
    private GamesRepository gamesRepository;

    @Transactional
    public GamesDto getById(int id) throws Exception{
        try {
            return gamesRepository.findById(id).get().toGamesDto();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

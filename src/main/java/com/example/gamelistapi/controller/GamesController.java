package com.example.gamelistapi.controller;

import com.example.gamelistapi.dto.GamesDto;
import com.example.gamelistapi.model.Games;
import com.example.gamelistapi.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {
    @Autowired
    private GamesService gamesService;

    @GetMapping("/{id}")
    public ResponseEntity<GamesDto> getGameById(@PathVariable int id) throws Exception {
        try {
            GamesDto g = gamesService.getById(id);
            return ResponseEntity.ok().body(g);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}

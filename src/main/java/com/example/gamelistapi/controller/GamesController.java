package com.example.gamelistapi.controller;

import com.example.gamelistapi.dto.GamesDto;
import com.example.gamelistapi.model.Games;
import com.example.gamelistapi.repository.GamesRepository;
import com.example.gamelistapi.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GamesController {
    @Autowired
    private GamesService gamesService;

    @Autowired
    private GamesRepository gamesRepository;

    @GetMapping("/{id}")
    public ResponseEntity<GamesDto> getGameById(@PathVariable Long id) throws Exception {
        try {
            GamesDto g = gamesService.getById(id);
            return ResponseEntity.ok().body(g);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @PostMapping("/by-name")
    public ResponseEntity<List<GamesDto>> getGameByName(@RequestBody String name) throws Exception {
        try {
            List<GamesDto> g = gamesService.getByName(name);
            return ResponseEntity.ok().body(g);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping()
    public Page<GamesDto> listaGames(@RequestParam(required = false) String nameGame,
                                     @PageableDefault(sort="name", direction= Sort.Direction.ASC, page =0, size = 15) Pageable pagination){
        Page<Games> games;
        if(nameGame == null ){
            games = gamesRepository.findAll(pagination);
        }
        else{
            games = gamesRepository.findByNameContainingIgnoreCase(nameGame, pagination);
        }
        return GamesDto.toGamesDto(games);

    }

}

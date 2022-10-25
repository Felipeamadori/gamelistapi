package com.example.gamelistapi.repository;

import com.example.gamelistapi.model.UsuarioGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioGamesRepository extends JpaRepository<UsuarioGames, Integer> {

    @Query(nativeQuery = true,value = "INSERT INTO usuario_games (id_usuario_games,id_game,id_usuario) " +
            "VALUES (DEFAULT, :idGame, :idUser);")
    void addGame(int idGame, int idUser);


}

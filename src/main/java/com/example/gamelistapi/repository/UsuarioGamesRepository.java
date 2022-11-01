package com.example.gamelistapi.repository;

import com.example.gamelistapi.model.UsuarioGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioGamesRepository extends JpaRepository<UsuarioGames, Long> {
}

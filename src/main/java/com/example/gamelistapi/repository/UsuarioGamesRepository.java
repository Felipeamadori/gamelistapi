package com.example.gamelistapi.repository;

import com.example.gamelistapi.model.UsuarioGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioGamesRepository extends JpaRepository<UsuarioGames, Long> {
}

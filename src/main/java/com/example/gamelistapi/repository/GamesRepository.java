package com.example.gamelistapi.repository;

import com.example.gamelistapi.model.Games;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface GamesRepository extends JpaRepository<Games, Long> {
    Page<Games> findByNameContainingIgnoreCase(String nameGame, Pageable pagination);
}

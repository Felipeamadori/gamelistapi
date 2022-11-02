package com.example.gamelistapi.repository;

import com.example.gamelistapi.dto.GamesDto;
import com.example.gamelistapi.model.Games;
import com.example.gamelistapi.model.UsuarioGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioGamesRepository extends JpaRepository<UsuarioGames, Long> {
    @Query(nativeQuery = true,
            value = "select g.id " +
                    "from games g join usuario_games ug on g.id = ug.game_id " +
                    "join usuario u on ug.usuario_id = u.id " +
                    "where u.id = :id ")
    List<Long> findAllByUserId(@Param("id") Long id);
}

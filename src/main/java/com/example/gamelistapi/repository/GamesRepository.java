package com.example.gamelistapi.repository;

import com.example.gamelistapi.dto.GamesDto;
import com.example.gamelistapi.model.Games;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface GamesRepository extends JpaRepository<Games, Integer> {

@Repository
@EnableJpaRepositories
public interface GamesRepository extends JpaRepository<Games, Long> {

    @Override
    Optional<Games> findById(Integer integer);
    
    

    Page<Games> findByGenresContainingIgnoreCase(String genres, Pageable pagination);

    @Query(nativeQuery = true,
            value = "select * from games g where g.name ilike concat('%',:name,'%')")
    List<Games> findGamesByName(@Param("name") String name);
    
    Page<Games> findByNameContainingIgnoreCase(String nameGame, Pageable pagination);

}

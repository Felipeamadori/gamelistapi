package com.example.gamelistapi.repository;

import com.example.gamelistapi.model.Games;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


<<<<<<< Updated upstream
public interface GamesRepository extends JpaRepository<Games, Integer> {
    @Override
    Optional<Games> findById(Integer integer);
=======
@Repository
@EnableJpaRepositories
public interface GamesRepository extends JpaRepository<Games, Long> {
    Page<Games> findByNameContainingIgnoreCase(String nameGame, Pageable pagination);

    Page<Games> findByGenresContainingIgnoreCase(String genres, Pageable pagination);

    @Query(nativeQuery = true,
            value = "select * from games g where g.name ilike concat('%',:name,'%')")
    List<Games> findGamesByName(@Param("name") String name);
>>>>>>> Stashed changes

    Page<Games> findByNameContainingIgnoreCase(String nameGame, Pageable pagination);
}

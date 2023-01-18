package com.example.gamelistapi.repository;

import com.example.gamelistapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
@EnableJpaRepositories
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    @Modifying
    @Query(nativeQuery = true,
            value = "update usuario " +
                    "set nome = :name, bio = :bio, pfp_url = :pfp " +
                    "where id = :id ")
    void updateUserInfo(@Param("id") Long id,
                           @Param("name") String name,
                           @Param("bio") String bio,
                           @Param("pfp") String pfp_url);
}
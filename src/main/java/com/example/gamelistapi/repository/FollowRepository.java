package com.example.gamelistapi.repository;

import com.example.gamelistapi.model.Follow;
import com.example.gamelistapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    List<Follow> findAllByFollowe_Id(Long id);

    List<Follow> findAllByFollowing_Id(Long id);

    List<Follow> findByFollowe_Id(Long id);
    List<Follow> findByFollowing_Id(Long id);

    @Modifying
    @Query(nativeQuery = true,
            value = "delete " +
                    "from follow f " +
                    "where f.followe_id = :followeId and f.following_id = :followingId ")
    void unfollow(@Param("followeId") Long followeId, @Param("followingId") Long followingId);
}

package com.lottery.api.repository;

import com.lottery.api.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    boolean existsByGame(String game);
    boolean existsByEmail(String email);
}

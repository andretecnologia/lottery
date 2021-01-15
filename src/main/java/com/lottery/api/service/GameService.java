package com.lottery.api.service;

import com.lottery.api.entity.Game;
import com.lottery.api.config.ApiErrorEnum;
import com.lottery.api.logic.GamePlay;
import com.lottery.api.repository.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.Optional;

@Service
public class GameService {

    final GameRepository repository;
    final GamePlay gamePlay;

    public GameService(GameRepository repository, GamePlay gamePlay) {
        this.repository = repository;
        this.gamePlay = gamePlay;
    }

    public Page<Game> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Game> findById(Integer id) {
        Optional<Game> player = repository.findById(id);
        if(!player.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ApiErrorEnum.RECORD_NOT_FOUND_MESSAGE.getDescricao());
        }
        return repository.findById(id);
    }

    public Game save(Game game) {
        verifyIfExistsEmail(game.getEmail());
        game.setGame(generateGame());
        return repository.save(game);
    }

    private String generateGame(){
        String game = Arrays.toString(gamePlay.sortSequence());
        if(verifyIfExistsGame(game)){
           generateGame();
        }
        return game;
    }

    private boolean verifyIfExistsGame(String game){
        return repository.existsByGame(game);
    }

    private void verifyIfExistsEmail(String email) {
        if(repository.existsByEmail(email)){
            throw new ResponseStatusException(HttpStatus.CONFLICT, ApiErrorEnum.RECORD_IS_EXIST.getDescricao());
        }
    }
}

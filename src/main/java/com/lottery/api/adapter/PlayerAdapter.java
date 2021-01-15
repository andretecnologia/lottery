package com.lottery.api.adapter;

import com.lottery.api.entity.Game;
import com.lottery.api.controller.dto.GameDto;
import com.lottery.api.controller.form.GameForm;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


public class PlayerAdapter {

    public static Game playerFormToPlayer(GameForm gameForm){
        return Game.builder()
                .name(gameForm.getName())
                .email(gameForm.getEmail())
            .build();
    }

    public static GameDto playerToPlayerDto(Game game){
        return GameDto.builder()
                .id(game.getId())
                .name(game.getName())
                .email(game.getEmail())
                .game(game.getGame())
            .build();
    }

    public static List<GameDto> playersToPlayersDto(List<Game> games) {

        return games.stream().map(
                player -> GameDto.builder()
                .name(player.getName())
                .email(player.getEmail())
            .build()
        ).collect(Collectors.toList());
    }

    public  static Page<GameDto> playersPageToPlayersDtoPage (Page<Game> players){
        return players.map(GameDto::new);
    }
}

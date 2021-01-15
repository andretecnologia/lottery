package com.lottery.api.controller.dto;

import com.lottery.api.entity.Game;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameDto {

    private Integer id;
    private String name;
    private String email;
    private String game;

    public GameDto(Game game){
        this.id= game.getId();
        this.name= game.getName();
        this.email= game.getEmail();
        this.game= game.getGame();
    }
}

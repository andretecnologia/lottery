package com.lottery.api.controller;

import com.lottery.api.entity.Game;
import com.lottery.api.adapter.PlayerAdapter;
import com.lottery.api.controller.dto.GameDto;
import com.lottery.api.controller.form.GameForm;
import com.lottery.api.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class GameController {

    final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<GameDto>> findAll(
            @PageableDefault(sort = "name",direction = Sort.Direction.ASC,page=0, size = 1)Pageable pageable){
        Page<GameDto> playerDtos = PlayerAdapter.playersPageToPlayersDtoPage(service.findAll(pageable));
        return ResponseEntity.ok(playerDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Game>> findById(@Parameter(name = "Player id", example = "1", required = true)
                                                            @PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create player", description = "This method creates a new player")
    public ResponseEntity<GameDto> save(@Valid @RequestBody GameForm player){
        GameDto gameDto = PlayerAdapter.playerToPlayerDto(service.save(PlayerAdapter.playerFormToPlayer(player)));
        return ResponseEntity.status(HttpStatus.CREATED).body(gameDto);
    }
}

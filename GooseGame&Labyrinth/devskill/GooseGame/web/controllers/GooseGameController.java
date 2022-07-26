package school.devskill.GooseGame.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import school.devskill.GooseGame.DTOs.PlayerStatus;
import school.devskill.GooseGame.models.Player;
import school.devskill.GooseGame.services.interfaces.IGooseGameService;
import school.devskill.GooseGame.web.interfaces.IGooseGameController;
import school.devskill.exceptions.NoSuchPlayerException;

import java.util.List;

@RestController
@RequestMapping("/goosegame")
public class GooseGameController implements IGooseGameController {

    IGooseGameService GooseGameService;
    ObjectMapper jackson;

    @Autowired
    public GooseGameController(IGooseGameService gooseGameService, ObjectMapper jackson) {
        this.GooseGameService = gooseGameService;
        this.jackson = jackson;
    }

    @PostMapping("/addPlayers")
    public List<Player> addPlayers(@RequestBody List<Player> players){
        return GooseGameService.addPlayers(players);
    }


    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody @NonNull Player player){
        return GooseGameService.addPlayer(player);
    }

    @GetMapping("/getPlayers")
    public List<PlayerStatus> getPlayers(){
        try{
            return GooseGameService.getPlayers().stream().map(x -> jackson.convertValue(x, PlayerStatus.class)).toList();
        } catch (NoSuchPlayerException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "No players are currently in the game.", e);
        }
    }

    @GetMapping("/getPlayer/{player}")
    public PlayerStatus getPlayer(@PathVariable Player player){
        try{
            return jackson.convertValue(GooseGameService.getPlayer(player), PlayerStatus.class);
        } catch (NoSuchPlayerException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
            }
        }

    @PostMapping("/newTurn/{player}")
    public PlayerStatus newTurn(@PathVariable Player player) throws NoSuchPlayerException {
       try {
           return jackson.convertValue(GooseGameService.newTurn(player), PlayerStatus.class);
       } catch (NoSuchPlayerException e){
           throw new ResponseStatusException(
                   HttpStatus.NOT_FOUND, e.getMessage(), e);
       }
    }

    @PostMapping("/newRound")
    public List<PlayerStatus> newRound() throws NoSuchPlayerException {
        try {
            return GooseGameService.newRound().stream().map(x -> jackson.convertValue(x, PlayerStatus.class)).toList();
        } catch (NoSuchPlayerException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping("/reset")
    public void reset(){
        GooseGameService.reset();
    }

}

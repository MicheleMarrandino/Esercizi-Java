package school.devskill.Labyrinth.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import school.devskill.Labyrinth.models.Player;
import school.devskill.Labyrinth.services.interfaces.ILabyrinthService;
import school.devskill.Labyrinth.utilities.Direction;
import school.devskill.Labyrinth.web.interfaces.ILabyrinthController;
import school.devskill.exceptions.MethodNotAllowedException;
import school.devskill.exceptions.NoSuchPlayerException;

@RestController
@RequestMapping("/labyrinth")
public class LabyrinthController implements ILabyrinthController {

    ILabyrinthService labyrinthService;
    ObjectMapper jackson;

    @Autowired
    public LabyrinthController(ILabyrinthService labyrinthService, ObjectMapper jackson) {
        this.labyrinthService = labyrinthService;
        this.jackson = jackson;
    }

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody @NonNull Player player){
        try {
            return labyrinthService.addPlayer(new Player(player.getName()));
        } catch (NoSuchPlayerException e){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, e.getMessage(), e);
        }
    }

    @GetMapping("/getPlayer")
    public Player getPlayer() {
        try {
            return labyrinthService.getPlayer();
        } catch (NoSuchPlayerException e){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, e.getMessage(), e);
        }
    }

    @PostMapping("/{direction}")
    public Character[][] movePlayer(@PathVariable @NonNull String direction){
        try{
           return labyrinthService.newTurn(direction.toUpperCase());
        } catch (MethodNotAllowedException | NoSuchPlayerException e){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN, e.getMessage(), e);
        } finally {
           labyrinthService.getLabyrinth();
        }
    }

    @GetMapping("/labyrinth")
    public Character[][] showLabyrinth(){
        return labyrinthService.getLabyrinth();
    }

    @GetMapping("/reset")
    public String reset(){
        return labyrinthService.reset();
    }

}

package school.devskill.GooseGame.web.interfaces;

import lombok.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import school.devskill.GooseGame.DTOs.PlayerStatus;
import school.devskill.GooseGame.models.Player;
import school.devskill.exceptions.NoSuchPlayerException;

import java.util.List;

public interface IGooseGameController {
    List<Player> addPlayers(@RequestBody List<Player> players);
    Player addPlayer(@RequestBody @NonNull Player player);
    List<PlayerStatus> getPlayers();
    PlayerStatus getPlayer(@PathVariable Player player);
    PlayerStatus newTurn(@PathVariable Player player) throws NoSuchPlayerException;
    List<PlayerStatus> newRound() throws NoSuchPlayerException;
    void reset();
}

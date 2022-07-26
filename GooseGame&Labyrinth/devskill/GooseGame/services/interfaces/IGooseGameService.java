package school.devskill.GooseGame.services.interfaces;

import school.devskill.exceptions.NoSuchPlayerException;
import school.devskill.GooseGame.models.ISpecialCell;
import school.devskill.GooseGame.models.Player;

import java.util.List;

public interface IGooseGameService {

    List<Player> addPlayers(List<Player> players);

    Player addPlayer(Player player);
    List<ISpecialCell> create();
    Player newTurn(Player p) throws NoSuchPlayerException;
    List<Player> newRound() throws NoSuchPlayerException;
    List<Player> getPlayers() throws NoSuchPlayerException;
    Player getPlayer(Player player) throws NoSuchPlayerException;
    void reset();
}

package school.devskill.Labyrinth.services.interfaces;

import school.devskill.Labyrinth.models.Player;
import school.devskill.exceptions.MethodNotAllowedException;
import school.devskill.exceptions.NoSuchPlayerException;

public interface ILabyrinthService {
    Player addPlayer(Player player) throws NoSuchPlayerException;
    Player getPlayer() throws NoSuchPlayerException;
    Character[][] getLabyrinth();
    Character[][] newTurn(String direction) throws MethodNotAllowedException, NoSuchPlayerException;
    String reset();
}

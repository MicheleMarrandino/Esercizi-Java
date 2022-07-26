package school.devskill.GooseGame.services.classes;

import org.springframework.stereotype.Service;
import school.devskill.exceptions.NoSuchPlayerException;
import school.devskill.GooseGame.models.FrozenCell;
import school.devskill.GooseGame.models.ISpecialCell;
import school.devskill.GooseGame.models.JumpingCell;
import school.devskill.GooseGame.models.Player;
import school.devskill.GooseGame.services.interfaces.IGooseGameService;

import java.util.ArrayList;
import java.util.List;

@Service("GooseGameService")
public class GooseGameServiceImpl implements IGooseGameService {
    private List<Player> players = new ArrayList<>();
    private List<ISpecialCell> cells = new ArrayList<>();
    private final Integer limit = 14;
    private boolean gameOver = false;

    public GooseGameServiceImpl() {
        create();
    }

    public List<Player> addPlayers(List<Player> players){
        this.players.addAll(players);
        return players;
    }

    public Player addPlayer(Player player){
        this.players.add(player);
        return player;
    }

    public List<ISpecialCell> create() {
        for (int i = 0; i < limit; i++) {
            switch (i) {
                case 1 -> cells.add(new JumpingCell(2));
                case 5 -> cells.add(new JumpingCell(-1));
                case 7 -> cells.add(new JumpingCell(3));
                case 8 -> cells.add(new JumpingCell(0));
                case 9 -> cells.add(new FrozenCell());
                case 12 -> cells.add(new JumpingCell(3 * -1));
                default -> cells.add(null);
            }
        };
        return cells;
    }

    public Player newTurn(Player p) throws NoSuchPlayerException {
        p = getPlayer(p);
        if(!p.getIsFrozen() && !gameOver) {
            Integer dist = p.getPos() + p.rollTheDice();
            if(dist.equals(limit-1)) {
                this.gameOver = true;
                p.setIsTheWinner(true);
            }
            if(!gameOver && dist < limit-1) {
                p.setPos(dist);
                ISpecialCell designatedCell = cells.get(p.getPos());
                if (designatedCell != null) {
                   p = designatedCell.execute(p);
                }
            }
        } else if(p.getIsFrozen()) p.setIsFrozen(false);

        return p;
    }

    public List<Player> newRound() throws NoSuchPlayerException {
        for(int i = 0; i< getPlayers().size(); i++){
            newTurn(players.get(i));
        }
        return players;
    }

    public void reset(){
        players.clear();
    }

    public List<Player> getPlayers() throws NoSuchPlayerException {
        if(players.size() <= 0)  throw new NoSuchPlayerException();
        return players;
    }

    public Player getPlayer(Player player) throws NoSuchPlayerException {
            for (Player x: players) {
                if(x.getName().equals(player.getName()))
                    return x;
            }
        throw new NoSuchPlayerException();
    }
}

package school.devskill.Labyrinth.services.classes;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import school.devskill.Labyrinth.models.Player;
import school.devskill.Labyrinth.services.interfaces.ILabyrinthService;
import school.devskill.Labyrinth.utilities.Tuple;
import school.devskill.exceptions.MethodNotAllowedException;
import school.devskill.exceptions.NoSuchPlayerException;

@Service("LabyrinthService")
public class LabyrinthServiceImpl implements ILabyrinthService {

    private Player player;
    private final Integer rows = 8;
    private final Integer columns = 12;
    private final Character[][] labyrinth =
    {       {'s','s','s','s','s','s','x','x','x','x','x','x'},
            {'x','x','x','x','x','s','x','x','x','x','x','x'},
            {'x','x','x','x','x','s','x','x','x','x','x','x'},
            {'x','x','x','x','x','s','s','s','s','s','s','x'},
            {'x','x','s','s','s','s','x','x','x','x','x','x'},
            {'x','x','x','x','x','s','x','x','x','x','x','x'},
            {'x','x','x','x','x','s','x','x','x','x','x','x'},
            {'x','x','x','x','x','u','x','x','x','x','x','x'},
    };
    private Boolean isGameOver = false;


    public Player addPlayer(@NonNull Player player) throws NoSuchPlayerException {
        if(this.player == null) {
            this.player = player;
            return player;
        } else throw new NoSuchPlayerException("A Player is still playing.");
    }

    public Player getPlayer() throws NoSuchPlayerException {
        if(player == null)
            throw new NoSuchPlayerException("No player is currently playing.");
       return player;
    }

    private void showLabyrinth(){
        for(int i=0; i<rows; i++){
            System.out.println("\n");
            for(int j=0; j<columns; j++){
                System.out.print(labyrinth[i][j] + " ");
            }
        }
        System.out.println("\n");
    }

    public Character[][] getLabyrinth(){
        return labyrinth;
    }

    public Character[][] newTurn(String direction) throws MethodNotAllowedException, NoSuchPlayerException {
        if(!isGameOver && getPlayer().equals(player)) {
            showLabyrinth();
            markPos('P');
            Tuple designatedPos = player.findPos(direction);
            if (isAllowed(designatedPos)) {
                markPos('v');
                player.apply();
                if (labyrinth[player.getCurrentPos().getR()][player.getCurrentPos().getC()].equals('u')) {
                    this.isGameOver=true;
                }
                markPos('P');
            } else {
                player.refuse();
            }
        }
        showLabyrinth();
        return getLabyrinth();
    }

    public String reset() {
        player = null;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(labyrinth[i][j].equals('v')||labyrinth[i][j].equals('P')){
                    labyrinth[i][j] = 's';
                }
            }
        }
        return "Game cleared correctly";
    }

    private void markPos(Character x){
        labyrinth[player.getCurrentPos().getR()][player.getCurrentPos().getC()] = x;
    }
    private boolean isAllowed(Tuple pos) throws MethodNotAllowedException{
        System.out.println(pos);
        if((pos.getR() < 0 || pos.getR() > rows || pos.getC() > columns || pos.getC() < 0) || (labyrinth[pos.getR()][pos.getC()].equals('x'))){
            player.refuse();
            throw new MethodNotAllowedException("You can't go there.");
        }
        return true;
    }

}

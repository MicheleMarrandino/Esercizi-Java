package school.devskill.Labyrinth.utilities;

import school.devskill.exceptions.NotADirectionException;

import java.util.Objects;

public class Direction {

    String direction;

    public Direction(String direction) throws NotADirectionException{
        if(!(direction.equals("UP")||direction.equals("DOWN")||direction.equals("LEFT")||direction.equals("RIGHT"))){
            throw new NotADirectionException();
        }
        this.direction = direction;
    }

    public String toUpperCase(){
        return direction.toUpperCase();
    }

}

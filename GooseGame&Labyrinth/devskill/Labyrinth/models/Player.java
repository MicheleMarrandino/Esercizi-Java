package school.devskill.Labyrinth.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import school.devskill.Labyrinth.utilities.Tuple;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Player {
    public Tuple currentPos;
    private String name;
    @JsonIgnore
    private Tuple seePos;

    public Player(String name) {
        this.name = name;
        this.currentPos = new Tuple(0, 0);
        this.seePos = new Tuple(0, 0);
    }

    public Tuple findPos(String direction) {
        switch (direction) {
            case "UP" -> seePos.setR(currentPos.getR() - 1);
            case "DOWN" -> seePos.setR(currentPos.getR() + 1);
            case "LEFT" -> seePos.setC(currentPos.getC() - 1);
            case "RIGHT" -> seePos.setC(currentPos.getC() + 1);
        }
        return seePos;
    }

    public void apply() {
        this.currentPos.setR(this.seePos.getR());
        this.currentPos.setC(this.seePos.getC());
    }

    public void refuse() {
        this.seePos.setR(this.currentPos.getR());
        this.seePos.setC(this.currentPos.getC());
    }

}

package school.devskill.GooseGame.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.security.SecureRandom;
import java.util.Random;

@Getter @Setter
@ToString @NoArgsConstructor
public class Player {
    @JsonProperty(required = true)
    private String name;
    private Boolean isFrozen = false;
    private Integer pos = 0;
    private Integer rollsCount = 0;
    private Integer lastRoll = 0;
    private Boolean isTheWinner = false;

    public Player(String name) {
        this.name = name;
    }

    public Integer rollTheDice(){
        rollsCount++;
        Random generate = new SecureRandom();
        this.lastRoll = generate.nextInt(6) + 1;
        return this.lastRoll;
    }

}

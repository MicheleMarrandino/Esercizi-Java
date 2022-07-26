package school.devskill.GooseGame.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class PlayerStatus {
    String name;
    Boolean isFrozen;
    Integer pos;
    Integer rollsCount;
    Integer lastRoll;
    Boolean isTheWinner;
}

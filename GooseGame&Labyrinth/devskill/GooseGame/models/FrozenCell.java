package school.devskill.GooseGame.models;

import lombok.*;

@NoArgsConstructor
public class FrozenCell implements ISpecialCell {
    @Override
    public Player execute(Player player) {
        player.setIsFrozen(true);
        return player;
    }
}

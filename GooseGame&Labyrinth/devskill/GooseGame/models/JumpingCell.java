package school.devskill.GooseGame.models;

import lombok.*;


@NoArgsConstructor
@Getter
public class JumpingCell implements ISpecialCell {
    private Integer jumpDistance;

    public JumpingCell(Integer jumpDistance){
        this.jumpDistance = jumpDistance;
    }

    @Override
    public Player execute(Player player) {
       player.setPos(jumpDistance + player.getPos());
       return player;
    }
}

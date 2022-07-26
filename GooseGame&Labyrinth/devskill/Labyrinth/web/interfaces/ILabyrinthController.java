package school.devskill.Labyrinth.web.interfaces;

import lombok.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import school.devskill.Labyrinth.models.Player;

public interface ILabyrinthController {
    Player addPlayer(@RequestBody @NonNull Player player);
    Player getPlayer();
    Character[][] movePlayer(@PathVariable @NonNull String direction);
    Character[][] showLabyrinth();
    String reset();
}

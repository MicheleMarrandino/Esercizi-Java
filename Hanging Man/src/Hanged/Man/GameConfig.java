package Hanged.Man;

public abstract class GameConfig {
    protected Integer lives;
    protected Integer streak;
    protected Boolean withHint;

    protected GameConfig(Integer lives, Boolean withHint) {
        this.lives = lives;
        this.withHint = withHint;
    }

}

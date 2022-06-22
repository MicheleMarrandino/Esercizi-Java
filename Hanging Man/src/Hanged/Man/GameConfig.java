package Hanged.Man;

public abstract class GameConfig {
    protected Integer lives = 5;
    protected Integer streak;

    protected Boolean withHint = false;

    protected GameConfig(Integer lives, Boolean withHint) {
        this.lives = lives;
        this.withHint = withHint;
    }

}

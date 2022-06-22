package Hanged.Man;

import Hanged.Man.Hidden.Hidden;
import Hanged.Man.Utility.Logger;

import java.io.IOException;
import java.util.Scanner;

public class Board extends GameConfig{
    protected Hidden hiddenWord;
    protected Integer correct = 0;

    public Logger log = new Logger();

    public Board(StringBuilder hiddenWord, Integer lives, Boolean withHint) {
        super(lives, withHint);
        this.hiddenWord = new Hidden(hiddenWord);
        this.streak = (hiddenWord.length()/2);
        System.out.println("Benvenuto nel gioco dell'impiccato!");
        play();
    }

    protected void play(){
        while(!this.hiddenWord.checkValidity() && lives > 0) {
            log.green("Ecco la tua parola: \n\n\t" + hiddenWord.getHiddenWord() + "\nVite: " + "🧡".repeat(this.lives) + "\n\ninserisci una lettera:");
            Scanner sc = new Scanner(System.in);
            if (!this.hiddenWord.findAndReplace(sc.next().charAt(0))) wrongAnswer();
            else checkStreak(++correct);
        }
        if(this.hiddenWord.checkValidity()) log.green("\nHai vinto! La parola era " + this.hiddenWord.getHiddenWord());
        else log.red("Hai perso...");
    }

    private void checkStreak(int x){
        if(x>=streak) {
            lives++;
            correct = 0;
        }
    }

    private void wrongAnswer(){
        if(withHint && --lives> 0)
            log.yellow("\n\b\bForse vuoi provare con una " + this.hiddenWord.getHint() + "...");
    }

}

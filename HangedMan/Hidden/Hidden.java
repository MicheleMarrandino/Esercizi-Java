package Hanged.Man.Hidden;

import static java.lang.Character.toUpperCase;

public class Hidden {
    private StringBuilder word;
    private StringBuilder hiddenWord;

    public Hidden(StringBuilder word) {
        this.word = word;
        this.hiddenWord = new StringBuilder("*".repeat(word.length()));
    }

    public StringBuilder getHiddenWord() {
        return hiddenWord;
    }

    public boolean checkValidity(){
        return word.toString().equals("*".repeat(hiddenWord.length()));
    }

    public boolean findAndReplace(char c){
        if(c == '*') return false;
        c = toUpperCase(c);
        boolean flag = false;

        for(int i = 0; i < word.length(); i++) {
            if(c == word.charAt(i)){
                hiddenWord.setCharAt(i, c);
                word.setCharAt(i, '*');
                flag = true;
            }
        }
        return flag;
    }

    public char getHint(){
        char x = ' ';
        for (int i = 0; i < word.length(); i++) {
            x = word.charAt(i);
            if(x != '*') return x;
        }
        return x;
    }

}

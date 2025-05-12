package Game;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int noOfDice;

    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }
    public int rollDice(){
        int  min=1;
        int max=6;
        int totalSum=0;
        int diceUsed=0;

        while(diceUsed<noOfDice){

            totalSum += ThreadLocalRandom.current().nextInt(min,max);
            diceUsed++;
        }

        return totalSum;
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungoenCharachter;

import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author arsch_000
 */
public class Dice {
    private static final Random random = new Random();
    private int dice;
    private int sides;
    public Dice(int dice, int sides){
        this.dice = dice;
        this.sides = sides;
    }
    public int roll(){
         return Dice.roll(dice, sides);
    }
    public static int roll(int dice, int sides){
        int total = 0;
        for(int i = 0; i < dice; i++){
            total += random.nextInt(sides) + 1;
        }
        return total;
    }
}

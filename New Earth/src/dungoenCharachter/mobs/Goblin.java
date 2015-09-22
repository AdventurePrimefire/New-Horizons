/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungoenCharachter.mobs;

import dungoenCharachter.CharachterSheet;
import dungoenCharachter.Dice;

/**
 *
 * @author arsch_000
 */
public class Goblin extends CharachterSheet{
    public Goblin(){
        super();
        super.setFullHitPoints(4);
        super.setAttackDice(new Dice(1,4));
    }
    public int getAttack(){
        return 2;
    }
    public int getDefence(){
        return 2;
    }
    public String getName(){
        return "Goblin";
    }
}

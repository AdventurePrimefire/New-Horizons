/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungoenCharachter.Mobs;

import dungoenCharachter.CharachterSheet;
import dungoenCharachter.Dice;


public class Troll extends CharachterSheet {
    private int DamageResistance = 2;
    public Troll(){
        super();
        super.setFullHitPoints(20);
        super.setAttackDice(new Dice(2,2));
    }
    public String getName(){
        return "Troll";
    }
    public int getDefence(){
        return -4;
    }
    public int getAttack(){
        return -1;
    }
    public int takeDamage(int Damage){
        if(Damage > DamageResistance){
        super.takeDamage(Damage - DamageResistance);
        return Damage - DamageResistance;
        }
        return 0;
        
    }            
}

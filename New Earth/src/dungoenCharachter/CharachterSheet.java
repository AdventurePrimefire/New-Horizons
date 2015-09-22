/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungoenCharachter;

/**
 *
 * @author arsch_000
 */
public class CharachterSheet {
    private int FullHitPoints = 1;
    private int CurrentHitPoints = 1;
    private int Attack = 0;
    private int Defence = 0;
    private Dice AttackDice = new Dice(1,2);
    public int getFullHitPoints(){
        return FullHitPoints;
    }
    public void setFullHitPoints(int HP){
        this.FullHitPoints = HP;
        this.CurrentHitPoints = this.FullHitPoints;
    }
    public int getCurrentHitPoints(){
        return CurrentHitPoints;
    }
    public void setCurrentHitPoints(int HP){
        this.CurrentHitPoints = HP;
    }
    public int takeDamage(int Damage){
        this.CurrentHitPoints -= Damage;
        return Damage;
    }
    public int getAttack(){
        return Attack;
    }
    public void setAttack(int Attack){
        this.Attack = Attack;
    }
    public int getDefence(){
        return Defence;
    }
    public void setDefence(int Defence){
        this.Defence = Defence;
    }
    public Dice getAttackDice(){
        return AttackDice;
    }
    public void setAttackDive(Dice dice){
        this.AttackDice = dice;
    }
    public int rollAttack() {
        if(AttackDice != null){
        return AttackDice.roll();
        } else {
            return 0;
        }
    }
    public String getName(){
        return "Default Charachter";
    }

    public void setAttackDice(Dice dice) {
        this.AttackDice = dice;
    }
}

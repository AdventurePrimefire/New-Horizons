package dungoenCharachter;

public class CombatSimulator {
    private CharachterSheet mob1 = null;
    private CharachterSheet mob2 = null;

    public CombatSimulator(CharachterSheet mob1, CharachterSheet mob2) {
        this.mob1 = mob1;
        this.mob2 = mob2;
    }
    public void runCombatStep(){
        System.out.println("Attacking");
        if(checkVictory()== null){
            this.runAttack(mob1,mob2);
            if(checkVictory()== null){
                this.runAttack(mob2, mob1);
            }
        }
    }
    private void runAttack(CharachterSheet m1, CharachterSheet m2){
        int AttackScore = Dice.roll(1, 20)+ m1.getAttack();
        int DefenceScore = Dice.roll(1, 20)+ m2.getDefence();
        int Damage = 0;
        if(AttackScore >= DefenceScore){
            Damage = m1.rollAttack();
            Damage = m2.takeDamage(Damage);
        }
        System.out.println(m1.getName() + " attacked " + m2.getName() + " and dealt "+ Damage + " damage");
    }
    public CharachterSheet checkVictory(){
        boolean loss1 = false;
        boolean loss2 = false;
        if(mob1.getCurrentHitPoints() <= 0){
            loss1 = true;
        }
        if(mob2.getCurrentHitPoints() <= 0){
            loss2 = true;
        }
        if(loss1){
            return mob1;
        } else if (loss2){
            return mob2;
        }
        return null;
    }
}

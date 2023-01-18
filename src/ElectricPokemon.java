import java.util.Scanner;

public class ElectricPokemon extends Pokemon{
    private int currentEnergy;
    private boolean specialAction;

    private static final int MAX_ENERGY = 100;
    private static final int ADD_ENERGY = 5;
    private static final int PERCENTAGE_MAX = 100;
    private static final int LIMIT_HP_PER= 20;



    public ElectricPokemon(String[] names, int[] hpMax, int[] apMax, Attack[] attack,int maxLvl) {
        super(names, hpMax, apMax, attack,maxLvl);
        this.currentEnergy = 0;
        this.specialAction = true;
    }

    public boolean specialAction(Pokemon attacked){
        boolean success = false;
        if (this.specialAction){
            this.currentHp = hpMax[this.currentLevel-1];
            this.currentAp = apMax[this.currentLevel-1];
            this.specialAction = false;
            success = true;
        }
        else System.out.println("You can only use this action once during the game and you have already used it.");
        return success;
    }

    public void electricPokemonFeature(){
       int checkHP =  hpMax[currentLevel-1]*LIMIT_HP_PER / PERCENTAGE_MAX;
        if ((this.currentEnergy < MAX_ENERGY) && checkHP < currentHp){
            this.currentEnergy += ADD_ENERGY;
        }
        else if (checkHP>currentHp){
            this.currentEnergy = 0;
        }
    }

    private double getCurrentEnergyPercent() {
        double multiplier =this.currentEnergy+100;
        multiplier/=100;
        return multiplier;
    }

        public boolean useAttack (Pokemon attacked){
        int damage;
        int attackChoice = 0;
        boolean success = true;
        Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < this.currentLevel; i++) {
                System.out.println((i + 1) + ")" + this.attacks[i]);
            }
        do {
            attackChoice = scanner.nextInt();
        }while (attackChoice > currentLevel || attackChoice < 0 );
        Attack attack = attacks[attackChoice-1];
        damage = (int)(attack.getDmg() * getCurrentEnergyPercent());
            if (removeAp(attack.getApCost())){
                if (tripleAttackDamage) {
                    System.out.println("The attacked Pokemon: " + attacked.name +": -"+damage*3+" HP");
                    attacked.removeHp(damage * 3);
                    tripleAttackDamage = false;
                }
                else {
                    attacked.removeHp(damage);
                    System.out.println("The attacked Pokemon: " + attacked.name +": -"+damage+" HP");
                }
            }
            else {
                System.out.println("You dont have enough AP");
                success = false;
            }
        return success;
    }

    public String toString() {
        return super.toString() +", "+ this.currentEnergy + "(ENERGY)";
    }


}

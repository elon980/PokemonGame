import java.util.Random;
import java.util.Scanner;

public abstract class  FirePokemon extends Pokemon{
    private static final int RESET_AP = 0;
    private static final int HP_HALF = 2;


    public FirePokemon(String[] names, int[] hpMax, int[] apMax, Attack[] attack,int maxLvl) {
        super(names, hpMax, apMax, attack,maxLvl);
    }

    public boolean specialAction(Pokemon attacked){
        Random random = new Random();
        int attack1 = random.nextInt(this.currentLevel);
        int attack2 = random.nextInt(this.currentLevel);
        int damage = this.attacks[attack1].getDmg() + this.attacks[attack2].getDmg();
        attacked.removeHp(damage);
        System.out.println(attacked.name + " You have damaged: " + damage + " (HP)");
        this.currentAp = RESET_AP;
        this.currentHp /= HP_HALF;
        return true;
    }


        public int firePokemonFeature(){
        Random random = new Random();
        int hpToRemove = 0;
        int reasonability = random.nextInt(1,5);
        if (reasonability == 1){
            hpToRemove = random.nextInt(3,11);
            this.removeHp(hpToRemove);
            System.out.println("damage by your attack: " +hpToRemove);
        }
        return hpToRemove;
    }

    public boolean useAttack(Pokemon attacked){
        int damage;
        int attackChoice = 0;
        boolean success = true;
        Scanner scanner = new Scanner(System.in);
        if (this.maxLvl == 1){
            for (int i = 0; i < this.attacks.length; i++) {
                System.out.println((i+1) + ")" + this.attacks[i]);
            }
            do {
                attackChoice = scanner.nextInt();
            }while (attackChoice > this.attacks.length || attackChoice <= 0 );
        }
        else {
            for (int i = 0; i < this.currentLevel; i++) {
                System.out.println((i + 1) + ")" + this.attacks[i]);
            }
            do {
                attackChoice = scanner.nextInt();
            }while (attackChoice > currentLevel || attackChoice <= 0 );
        }
        Attack attack = attacks[attackChoice-1];
        damage = attack.getDmg();
        if (removeAp(attack.getApCost())){
            if (tripleAttackDamage) {
                System.out.println("The attacked Pokemon: " + attacked.name +": -"+damage*3+" HP");
                 int seldDmg = firePokemonFeature();
                System.out.println("The attacking Pokemon: " + name + ": -"+ seldDmg + " HP");
                attacked.removeHp(damage * 3);
                tripleAttackDamage = false;
            }
            else {
                attacked.removeHp(damage);
                System.out.println("The attacked Pokemon: " + attacked.name +": -"+damage+" HP");
                int seldDmg = firePokemonFeature();
                System.out.println("The attacking Pokemon: " + name + ": -"+ seldDmg + " HP");
            }
        }
        else {
            System.out.println("You dont have enough AP");
            success = false;
        }
        return success;
    }

}

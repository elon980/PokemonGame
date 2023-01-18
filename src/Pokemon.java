import java.util.Random;
import java.util.Scanner;

public abstract class Pokemon {
    private String[] names;
    protected String name;
    protected int maxLvl;
    protected int currentLevel;
    protected int hpMax[];
    protected int currentHp;
    protected int apMax[];
    protected int currentAp;
    protected Attack attacks[];
    protected boolean tripleAttackDamage;

    private static final int START_LEVEL = 1;
    private static final int MIN_WAIT_HP_ADD = 5;
    private static final int MAX_WAIT_HP_ADD = 30;
    private static final int MAX_WAIT_AP_ADD = 40;
    private static final int EVOLVE_2_HP_COST = 20;
    private static final int EVOLVE_2_AP_COST = 25;
    private static final int EVOLVE_3_HP_COST = 30;
    private static final int EVOLVE_3_AP_COST = 40;
    private static final int HP_ADD_PER_TURN_RND = 4;
    private static final int AP_ADD_PER_TURN_RND = 4;

    public abstract boolean useAttack (Pokemon attacked);

    public Pokemon(String[] names, int[] hpMax, int[] apMax, Attack[] attack,int maxLvl){
        this.names = names;
        this.currentLevel = START_LEVEL;
        this.name = names[currentLevel-1];
        this.hpMax = hpMax;
        this.currentHp = hpMax[0];
        this.apMax = apMax;
        this.currentAp = (int)(apMax[0]*0.75);
        this.attacks = attack;
        this.maxLvl = maxLvl;
        this.tripleAttackDamage = false;
    }

    public String toString() {
        return this.name + ": "+ this.currentHp + "/"+this.hpMax[currentLevel -1] + "(HP), "+currentAp +  "/"+ apMax[currentLevel -1]+"(AP)";
    }

    public void addHpAndAp(){
        Random random = new Random();
        int hpAdd = random.nextInt(HP_ADD_PER_TURN_RND+1);
        if (this.currentHp + hpAdd > this.hpMax[this.currentLevel - 1])
            this.currentHp = hpMax[this.currentLevel-1];
        else
            this.currentHp += hpAdd;
        int apAdd = random.nextInt(AP_ADD_PER_TURN_RND+1);
        if (this.currentAp + apAdd > apMax[this.currentLevel-1])
            this.currentAp = apMax[this.currentLevel-1];
        else
            this.currentAp += apAdd;
        System.out.println(this.name+": +" + hpAdd +"(HP) & +"+apAdd+"(AP)");
    }

    public abstract boolean specialAction(Pokemon attacked);

    public boolean waiting(){
        Random random = new Random();
        int suprise = random.nextInt(1,4);
        switch (suprise){
            case 1: hpAddRandom(); break;
            case 2: apAddRandom(); break;
            case 3: tripleAttackDamageRandom(); break;
        }
        return true;
    }
    private void tripleAttackDamageRandom(){
        this.tripleAttackDamage = true;
        System.out.println(this.name + ", you got Triple Attack Damage for next attack ");
    }

    private void apAddRandom(){
        Random random = new Random();
        int apAdd = random.nextInt(MAX_WAIT_AP_ADD);
        if (this.currentAp+apAdd > apMax[currentLevel-1])
            this.currentAp = apMax[currentLevel-1];
        else
            this.currentAp += apAdd;
        System.out.println(this.name + " : +"+ apAdd + " (AP) for waiting");
    }

    private void hpAddRandom(){
        Random random = new Random();
        int hpAdd = random.nextInt(MIN_WAIT_HP_ADD,MAX_WAIT_HP_ADD+1);
        if (this.currentHp+hpAdd > hpMax[currentLevel-1])
            this.currentHp = hpMax[currentLevel-1];
        else
            this.currentHp += hpAdd;
        System.out.println(this.name + " : +"+ hpAdd + " (HP) for waiting");
    }

    public boolean removeHp(int hpToRemove) {
        boolean hasHp = true;
        if (this.currentHp - hpToRemove > 0) {
            this.currentHp -= hpToRemove;
        } else {
            this.currentHp=0;
            hasHp = false;
        }
        return hasHp;
    }

    public boolean kick(Pokemon pokemonDamaged){
        pokemonDamaged.currentHp = pokemonDamaged.currentHp-Constants.KICK_DMG;
        System.out.println(pokemonDamaged.name + ": -"+Constants.KICK_DMG + "(HP)");
        return true;
    }

    public boolean removeAp(int toRemove){
        boolean done = true;
        if ((this.currentAp - toRemove) > 0)
            this.currentAp -= toRemove;
        else
            done = false;
        return done;
    }

    public boolean evolution (){
        boolean success = false;
        if (this.currentLevel < this.maxLvl) {
            switch (this.currentLevel){
                case 1: if (this.currentAp>=EVOLVE_2_AP_COST){
                        if (this.currentHp > EVOLVE_2_HP_COST) {
                            removeHp(EVOLVE_2_HP_COST);
                            removeAp(EVOLVE_2_AP_COST);
                            this.currentLevel++;
                            this.name = this.names[currentLevel-1];
                            success = true;
                        }
                        else
                            System.out.println("You dont have enough HP");
                }
                else
                    System.out.println("You dont have enough AP");
                break;
                case 2: if (this.currentAp >= EVOLVE_3_AP_COST){
                    if (this.currentHp > EVOLVE_3_HP_COST){
                        this.currentLevel++;
                        removeHp(EVOLVE_3_HP_COST);
                        removeAp(EVOLVE_3_AP_COST);
                        this.name = this.names[currentLevel-1];
                        success = true;
                    } else System.out.println("You dont have enough HP");
                }
                else System.out.println("You dont have enough AP");
                    break;
            }
        }
        else
            System.out.println("You are at your max level");
        if (success){
            System.out.println("The pokemon has evolved");
            System.out.println("You are now: " + this.name);
        }
        return success;
    }



}

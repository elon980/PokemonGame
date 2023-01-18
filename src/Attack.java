import java.util.Random;

public class Attack {
    Random random = new Random();
    private String name;
    private int apCost;
    private int maxDmg;
    private int minDmg;

    public Attack(String name,int apCost,int maxDmg,int minDmg){
        this.name = name;
        this.apCost = apCost;
        this.maxDmg = maxDmg;
        this.minDmg = minDmg;
    }

    public int getDmg(){
        int dmg;
        if (this.minDmg!=this.maxDmg) {
            dmg = random.nextInt(this.minDmg, this.maxDmg + 1);
        }else dmg = minDmg;
        return dmg;
    }
    public int getApCost(){
        return this.apCost;
    }
    public String getName(){
        return this.name;
    }

    public String toString() {
        String output = this.name + ": " + this.apCost+ "(AP)";
        if (minDmg!=maxDmg){
            output+= "," + minDmg + "-" + maxDmg + "(DMG)";
        }else output+= "," + minDmg+ "(DMG)";
        return output;
    }
}

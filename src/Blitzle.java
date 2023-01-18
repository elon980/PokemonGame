public class Blitzle extends  ElectricPokemon{

    public Blitzle() {
        super(new String[]{"Blitzle","Zebstrika "},
                new int[]{90, 100},
                new int[]{35, 50},
                new Attack[]{
                        new Attack("Flop", 20, 25, 20),
                        new Attack("Zap Kick", 30, 35, 30),
                }
                ,2);
    }
}

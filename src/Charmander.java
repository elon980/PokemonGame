public class Charmander extends FirePokemon{

    public Charmander() {
        super(new String[]{"Charmander","Charmeleon","Charizard"},
        new int[]{80, 90, 130},
                new int[]{40, 60, 80},
                new Attack[]{
                    new Attack("Scratch", 15, 30, 25),
                    new Attack("Flame Tale", 40, 50, 30),
                    new Attack("Fiery Blast", 50, 50, 50),
                }
        ,3);
    }
}

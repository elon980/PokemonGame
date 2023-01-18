public class Moltres extends FirePokemon {
    public Moltres() {
        super(new String[]{"Moltres"},
                new int[]{120},
                new int[]{60},
                new Attack[]{
                        new Attack("Assisting Heater", 30, 60, 10),
                        new Attack("Fire Wing", 30, 30, 30),
                },
                1);
    }
}

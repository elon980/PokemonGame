public class Electabuzz extends ElectricPokemon{

    public Electabuzz() {
        super(new String[]{"Electabuzz","Electivire "},
                new int[]{30,35},
                new int[]{100, 120},
                new Attack[]{
                        new Attack("Thunder", 60, 50, 40),
                        new Attack("Thunder Punch", 80, 120, 50),
                }
                ,2);
    }

}

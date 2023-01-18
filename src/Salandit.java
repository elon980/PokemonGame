public class Salandit extends FirePokemon{
    public Salandit() {
        super(new String[]{"Salandit","Salazzle"},
                new int[]{100, 160},
                new int[]{60,80},
                new Attack[]{
                    new Attack("Live Coal", 10, 25, 0),
                        new Attack("Fire Claws", 25, 50, 0),}
                ,2);
    }
}

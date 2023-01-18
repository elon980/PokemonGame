public class Pikachu extends ElectricPokemon{
    public Pikachu() {
        super(new String[]{"Pichu","Pikachu","Raichu"},
                new int[]{40, 50, 160},
                new int[]{30, 40, 80},
                new Attack[]{
                        new Attack("Quick Attack", 5, 10, 10),
                        new Attack("Electro Ball", 10, 40, 30),
                        new Attack("Electric Surfer", 60, 120, 20),
                }
                ,3);
    }
}

import java.util.Random;

public class main {
    public static void main(String[] args){
        Pokemon pokemon1 = randomPokemon();
        Pokemon pokemon2 = randomPokemon();
        Battle battle = new Battle(pokemon1,pokemon2);
        battle.startBattle();
    }

    public static Pokemon randomPokemon(){
        Random random = new Random();
        Pokemon pokemonRandom = null;
        int d = random.nextInt(1,7);
        switch (d){
            case 1: pokemonRandom = new Charmander(); break;
            case 2: pokemonRandom = new Salandit(); break;
            case 3: pokemonRandom = new Moltres(); break;
            case 4: pokemonRandom = new Pikachu(); break;
            case 5: pokemonRandom = new Blitzle(); break;
            case 6: pokemonRandom = new Electabuzz(); break;
        }
        return pokemonRandom;
    }
}

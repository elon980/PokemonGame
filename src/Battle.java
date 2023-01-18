import java.util.Scanner;

public class Battle {
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    public Battle(Pokemon pokemon1,Pokemon pokemon2){
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void startBattle(){
        boolean pokemon1Turn = true;
        do {
            System.out.println("Current status: \n Player 1 : " + this.pokemon1 + "\n" +
                    "Player 2: " + this.pokemon2);
            if (pokemon1Turn){
                System.out.println("Player 1 its your turn");
                menu(pokemon1,pokemon2);
            }
            else {
                System.out.println("Player 2 its your turn");
                menu(pokemon2, pokemon1);
            }
            pokemon1Turn = !pokemon1Turn;
        }while (winnerCheck(pokemon1Turn));
    }
    public boolean winnerCheck(boolean pokemon1Turn){
        boolean gameOver = true;
        if (!pokemon1Turn) {
            if (pokemon2.currentHp <= 0) {
                System.out.println("Player 1 is Winner");
                gameOver = false;
            }
        }
         else if (pokemon1.currentHp <= 0){
            System.out.println("Player 2 is Winner");
            gameOver = false;
        }
         if (gameOver){
             System.out.println("The turn is over, you got HP and AP");
             pokemon1.addHpAndAp();
             pokemon2.addHpAndAp();
         }
         return gameOver;
    }

    public void menu(Pokemon attacker,Pokemon attacked){
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        if (attacked instanceof ElectricPokemon)
            ((ElectricPokemon) attacked).electricPokemonFeature();
        if (attacker instanceof ElectricPokemon)
            ((ElectricPokemon) attacker).electricPokemonFeature();
        boolean success = false;
        do {
            System.out.println( "Chose what you want to do next (1 per turn):\n" +
                "1)Use attack ability\n" +
                "2)Wait\n" +
                "3)Evolve\n" +
                "4)Ultimate ability\n" +
                "5)Kick (-2 HP) (0 AP)");
        do {
             userChoice = scanner.nextInt();
        }while (userChoice > 5 || userChoice < 1);
            switch (userChoice){
                case 1: success = attacker.useAttack(attacked); break;
                case 2: success = attacker.waiting(); break;
                case 3: success = attacker.evolution(); break;
                case 4: success = attacker.specialAction(attacked); break;
                case 5: success =attacker.kick(attacked); break;
            }
        } while (!success);

    }
}

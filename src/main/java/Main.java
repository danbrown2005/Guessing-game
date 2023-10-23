import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputManager inputManager = new InputManager();

        DataTransformer transformer = new DataTransformer();

        ArrayList<GuessObject> guessObjects = transformer.csvToGuessObject(GameConstants.OBJECT_CSV_PATH);

        HashMap<String, ArrayList<GuessObject>> categorizedData = transformer.getCategorizedGuesses(guessObjects);

        ArrayList<Player> players = new ArrayList<>();
        int playerCount = inputManager.getValidInteger(GameConstants.PLAYER_COUNT_PROMPT, GameConstants.MIN_PLAYERS, GameConstants.MAX_PLAYERS);
        for (int i = 0; i < playerCount; i++) {
            System.out.println("Enter player " + (i + 1) + "'s name:");
            players.add(new Player(scanner.nextLine(), i));
        }

        ArrayList<String> validCategories = new ArrayList<>(categorizedData.keySet());

        String firstPlayer;

        do {
            System.out.println(GameConstants.FIRST_PLAYER_PROMPT);
            for (Player player : players) {
                System.out.println(player.getName() + "'s ID is " + player.getId());
            }
            firstPlayer = scanner.nextLine();
        } while (inputManager.isNotValidIntWithinRange(firstPlayer, GameConstants.MIN_PLAYER_ID, (players.size() - 1)));
        players.add(0, players.remove(Integer.parseInt(firstPlayer)));

        Random random = new Random();
        int roundCount = inputManager.getValidInteger(GameConstants.ROUND_COUNT_PROMPT, GameConstants.MIN_ROUNDS, GameConstants.MAX_ROUNDS);
        for (int round = 0; round < roundCount; round++) {
            System.out.println("=== ROUND " + (round + 1) + " ===");
            ArrayList<GuessObject> quizObjects = categorizedData.get(inputManager.getValidString(GameConstants.GAME_CATEGORY_PROMPT, validCategories));
            for (Player player : players) {
                System.out.println(player.getName() + "'s turn");
                int randomIndex = random.nextInt((quizObjects.size() - 1) + 1);
                GuessObject currentObject = quizObjects.get(randomIndex);
                quizObjects.remove(randomIndex);
                for (int i = 0; i < currentObject.getHints().size(); i++) {
                    System.out.println("Hint: " + currentObject.getCurrentHint());
                    if (currentObject.checkGuess(scanner.nextLine())) {
                        player.increasePoints(currentObject.getPoints());
                        break;
                    }
                }
                if (currentObject.getPoints() == 0) {
                    System.out.println("The item was a " + currentObject.getName() + " and you gained " + currentObject.getPoints() + " points");
                }

            }
        }
        System.out.println("==========");
        System.out.println("FINAL SCORES");
        System.out.println("==========");
        for (Player player : players) {
            System.out.println(player);
        }

        scanner.close();
    }
}

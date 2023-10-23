public class GameConstants {
    // FILE PATH CONSTANTS
    static final String OBJECT_CSV_PATH = "src/main/resources/objects.csv";
    // GAME LOGIC CONSTANTS
    static final int MIN_PLAYERS = 2;
    static final int MAX_PLAYERS = 4;
    static final int MIN_ROUNDS = 1;
    static final int MAX_ROUNDS = 3;
    static final int MIN_PLAYER_ID = 0;
    // PROMPTS
    static final String PLAYER_COUNT_PROMPT = "How many people will be playing? (" + MIN_PLAYERS + "-" + MAX_PLAYERS + ")";
    static final String FIRST_PLAYER_PROMPT = "Which player would like to go first? (enter ID): ";
    static final String ROUND_COUNT_PROMPT = "How many rounds would you like to play? (" + MIN_ROUNDS + "-" + MAX_ROUNDS + "): ";
    static final String GAME_CATEGORY_PROMPT = "Enter game category:";

}

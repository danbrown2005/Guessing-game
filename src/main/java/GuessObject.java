import java.util.ArrayList;

public class GuessObject {

    private final String name;
    private final ArrayList<String> hints = new ArrayList<>();
    private final String category;
    private int points = 3;
    private int currentHint = 0;

    public ArrayList<String> getHints() {
        return hints;
    }

    public String getCurrentHint() {
        return this.hints.get(this.currentHint);
    }

    public int getPoints() {
        return points;
    }

    public GuessObject(String name, String hintA, String hintB, String hintC, String category) {
        this.name = name;
        this.hints.add(hintA);
        this.hints.add(hintB);
        this.hints.add(hintC);
        this.category = category;
    }

    public GuessObject(String[] object) {
        this(object[0], object[1], object[2], object[3], object[4]);
    }

    public String getName() {
        return name;
    }


    public String getCategory() {
        return category;
    }

    // TODO remove from class not appropriate!
    public boolean checkGuess(String guess) {
        if (guess.equalsIgnoreCase(this.name)) {
            System.out.println("You gained " + this.points + " points!");
            return true;
        } else {
            System.out.println("Incorrect!");
            this.currentHint++;
            points--;
            return false;
        }
    }

    @Override
    public String toString() {
        return this.name + ":" + this.category;
    }

}

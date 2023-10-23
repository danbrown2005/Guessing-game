public class Player {

    private final String name;

    private int points;

    private final int id;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void increasePoints(int amount) {
        if (amount <= 0) {
            return;
        }
        this.points += amount;
    }

    @Override
    public String toString() {
        return this.getName() + "(" + this.getId() + ")" + ":" + this.getPoints() + " points.";
    }

}

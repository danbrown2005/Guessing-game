import java.util.ArrayList;
import java.util.HashMap;

public class DataTransformer {

    public ArrayList<GuessObject> csvToGuessObject(String directory) {
        ArrayList<GuessObject> guessObjects = new ArrayList<>();
        ArrayList<String[]> data = FileController.readFile(directory);

        for (String[] object : data) {
            GuessObject guessObject = new GuessObject(object);
            guessObjects.add(guessObject);
        }
        return guessObjects;
    }


    public HashMap<String, ArrayList<GuessObject>> getCategorizedGuesses(ArrayList<GuessObject> objects) {
        HashMap<String, ArrayList<GuessObject>> categories = new HashMap<>();
        for (GuessObject guess : objects) {
            ArrayList<GuessObject> entry = categories.get(guess.getCategory());
            if (entry == null) {
                ArrayList<GuessObject> currentCategory = new ArrayList<>();
                currentCategory.add(guess);
                categories.put(guess.getCategory(), currentCategory);
            } else {
                entry.add(guess);
            }
        }
        categories.put("All", objects);
        return categories;
    }


}

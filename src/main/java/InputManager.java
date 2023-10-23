import java.util.ArrayList;
import java.util.Scanner;

public class InputManager {

    public boolean isNotValidIntWithinRange(String input, int minimum, int maximum) {
        try {
            int intInput = Integer.parseInt(input);
            if (intInput >= minimum && intInput <= maximum) {
                return false;
            } else {
                System.out.println("Please enter a valid number.");
                return true;
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid number.");
            return true;
        }
    }


    public int getValidInteger(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        String count;
        do {
            System.out.println(prompt);
            count = scanner.nextLine();
        } while (isNotValidIntWithinRange(count, min, max));
        return Integer.parseInt(count);

    }


    public String getValidString(String prompt, ArrayList<String> validStrings) {
        Scanner scanner = new Scanner(System.in);
        String category;
        do {
            System.out.println(prompt);
            System.out.println("Valid inputs: " + validStrings);
            category = scanner.nextLine();
        }
        while (!validStrings.contains(category));

        return category;

    }


}
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class FileController {

    public static ArrayList<String[]> readFile(String dir) {
        Scanner reader;
        try {
            reader = new Scanner(Paths.get(dir));
        } catch (IOException ignored) {
            return new ArrayList<>();
        }
        ArrayList<String> data = new ArrayList<>();

        while (reader.hasNextLine()) {

            data.add(reader.nextLine());
        }
        return formatFileData(data);
    }

    public static ArrayList<String[]> formatFileData(ArrayList<String> data) {
        ArrayList<String[]> formattedData = new ArrayList<>();
        for (String string : data) {
            formattedData.add(string.split(","));
        }

        return formattedData;
    }


}
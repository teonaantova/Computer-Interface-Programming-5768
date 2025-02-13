import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Path filePath = Paths.get("Lecture1/Task1/ binaryFine.bin");
        byte[] array = {1, 2, 3, 4, 5};

        try {
            Files.write(filePath, array);
            System.out.println("The content was successfully added to a file");

            byte[] readData = Files.readAllBytes(filePath);
            for (byte b : readData)
            System.out.println(b + " ");
        } catch (IOException e) {

        }
    }
}
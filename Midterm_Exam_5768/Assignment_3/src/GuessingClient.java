import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class GuessingClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 9000;

    public static void main(String[] args) {

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println(input.readLine());

            while (true) {

                System.out.print("Guess a number between 1 and 100 (or type 'exit' to quit): ");
                String guess = scanner.nextLine();
                output.println(guess);

                String response = input.readLine();
                if (response == null) break;
                System.out.println("Server says: " + response);
                if (response.startsWith("Correct!") || response.equals("Game ended.")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error: Could not connect to server.");
        }
    }
}




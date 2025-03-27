import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class GuessingServer {
    private static final int PORT = 9000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Guessing Server started on port " + PORT);

            while (true) {

                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    Random random = new Random();
                    int secretNumber = random.nextInt(100) + 1;
                    int attempts = 0;

                    output.println("Welcome to the Number Guessing Game! Guess a number between 1 and 100.");

                    while (true) {

                        String clientMessage = input.readLine();
                        if (clientMessage == null) break;

                        if (clientMessage.equalsIgnoreCase("exit")) {
                            output.println("Game ended.");
                            System.out.println("Game ended.");
                            break;
                        }

                        try {

                            int guess = Integer.parseInt(clientMessage);

                            attempts++;

                            if (guess < 1 || guess > 100) {
                                output.println("Invalid input. Please enter a number between 1 and 100.");
                            } else if (guess < secretNumber) {
                                output.println("Too low!");
                            } else if (guess > secretNumber) {
                                output.println("Too high!");
                            } else {
                                output.println("Correct! You guessed it in " + attempts + " attempts.");
                                System.out.println("Client guessed the correct number: " + secretNumber + " in " + attempts + " attempts.");
                                break;
                            }
                        } catch (NumberFormatException e) {

                            output.println("Invalid input. Please enter a number between 1 and 100.");
                        }
                    }

                    System.out.println("Client disconnected.");
                } catch (IOException e) {
                    System.out.println("Error handling client: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Error: Could not start server on port " + PORT);
        }
    }
}





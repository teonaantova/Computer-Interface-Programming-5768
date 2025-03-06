import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class UppercaseClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the server.");
            String input;

            while (true) {
                System.out.print("Enter a string (or 'exit' to quit): ");
                input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }
                printWriter.println(input);
                String response = bufferedReader.readLine();
                System.out.println("Response from server: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        Socket connectionSocket = serverSocket.accept();
        System.out.println("Client connected.");

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(connectionSocket.getOutputStream()), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

        String message = bufferedReader.readLine();
        System.out.println("Received from client: " + message);

        printWriter.println("Hello client!");

        connectionSocket.close();
        serverSocket.close();
    }
}
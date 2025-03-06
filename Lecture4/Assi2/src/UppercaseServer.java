import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class UppercaseServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is listening on port 8080...");

            while (true) {
                Socket connectionSocket = serverSocket.accept();
                System.out.println("Client connected.");
                new ClientHandler(connectionSocket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String message;
            while ((message = bufferedReader.readLine()) != null) {
                System.out.println("Received from client: " + message);
                String response = message.toUpperCase();
                printWriter.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("Client disconnected.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
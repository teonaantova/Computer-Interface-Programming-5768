import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client01 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8080);
        System.out.println("Connected to server.");

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        printWriter.println("Hello server!");

        String response = bufferedReader.readLine();
        System.out.println("Received from server: " + response);

        socket.close();
    }
}
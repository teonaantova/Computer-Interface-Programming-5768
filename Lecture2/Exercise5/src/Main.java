import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop applications are not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        File file = new File("text.txt");
        try{
            desktop.open(file);
        } catch (IOException e) {
            System.out.println("Error occurred while opening the file");
        }
    }
}
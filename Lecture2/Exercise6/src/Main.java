import javax.print.attribute.URISyntax;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {


        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop applications are not supported");
            return;
        }
        Desktop desktop = Desktop.getDesktop();
        File file = new File("text.txt");
        try {
            URI uri = new URI("mailto:teona.ahss@gmail.com/subject=testSubject&body=bodyContent");
            desktop.mail(uri);
        } catch (URISyntaxException e) {
            System.out.println("Error occurred while opening the file");
        } catch (IOException e) {

        }
    }
}
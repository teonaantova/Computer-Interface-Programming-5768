import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://uacs.edu.mk/home/home/");
            InputStream inputStream = new BufferedInputStream(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream("downloadUACS.html");

            byte[] buffereddata = new byte[1024];
            int byteRead;

            while ((byteRead = inputStream.read(buffereddata, 0, 1024)) != -1) {
                fileOutputStream.write(buffereddata, 0, byteRead);
            }

            System.out.println("Finished downloading");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


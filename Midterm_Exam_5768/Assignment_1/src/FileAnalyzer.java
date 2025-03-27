import java.io.*;
public class FileAnalyzer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FileAnalyzer <file_path>");
            return;
        }

        String filePath = args[0];
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("Error: File not found");
            return;
        }

        if (!file.canRead()) {
            System.out.println("Error: Cannot read file");
            return;
        }

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                charCount += line.length() + 1;
                wordCount += line.split("\\s+").length;
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("File: " + filePath);
        System.out.println("Total lines: " + lineCount);
        System.out.println("Total words: " + wordCount);
        System.out.println("Total characters: " + charCount);

    }

}
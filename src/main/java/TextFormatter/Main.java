package TextFormatter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<String> text = readFile();

        IFormat textFormat;
        while (true) {
            textFormat = getFormat(text);

            textFormat.printFormat();

            System.out.println("\n Type Y to confirm format choice, anything else will let you select a new format");
            Scanner scanner = new Scanner(System.in);
            String result = scanner.next().toLowerCase();
            if(result.equals("y")) break;
        }

        textFormat.createFile();
    }

    public static ArrayList<String> readFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a path to a .txt file");
        String filePath = scanner.next();
        if (!filePath.endsWith(".txt")){
            return readFile();
        }

        ArrayList<String> lines = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(filePath))) {
            while (fileScanner.hasNextLine()) {
                lines.add(fileScanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Please enter a real File!");
            readFile();
        }
        return lines;
    }

    public static IFormat getFormat(ArrayList<String> text){
        System.out.println("Please select a valid format type.");
        Scanner scanner = new Scanner(System.in);
        String formatName = scanner.next();
        return switch (formatName.toLowerCase()) {
            case "html" -> {
                System.out.println("Selected HTML");
                yield new HTMLFormat(text);
            }
            case "markdown" -> {
                System.out.println("Selected Markdown");
                yield new MarkDownFormat(text);
            }
            case "plaintext", "plain text" -> {
                System.out.println("Selected Plain Text");
                yield new PlainTextFormat(text);
            }
            default -> getFormat(text);
        };
    }
}

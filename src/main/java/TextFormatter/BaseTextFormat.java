package TextFormatter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BaseTextFormat {
    protected ArrayList<String> formattedText;
    protected String fileType = "";
    public void printFormat(){
        for(String i : formattedText){
            System.out.println(i);
        }
    }

    public void createFile() {
        System.out.println("Please enter where you would like to put your file. Do not include file extension");
        Scanner scanner = new Scanner(System.in);

        try (FileWriter writer = new FileWriter(scanner.next().trim() + fileType)) {
            for (String line : formattedText) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Something went wrong, please try another file");
            createFile();
        }
    }
}

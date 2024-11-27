package EventLogger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LogToFile implements ILogger{
    private PrintWriter writer;
    final String fileName;
    int iteration;


    public LogToFile(String fileName) {
        this.fileName = fileName;
        try {
            writer = new PrintWriter(new FileWriter(fileName+".txt", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        iteration = 0;
    }

    @Override
    public void log(String message) {
        writer.println(message); // Write log to file

    }

    @Override
    public void archive() {
        writer.flush();
        writer.close();

        iteration++;
        try {
            writer = new PrintWriter(new FileWriter(fileName + iteration + ".txt", true));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

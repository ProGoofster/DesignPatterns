package EventLogger;

public class LogToConsole implements ILogger {
    @Override
    public void log(String message) {
        System.out.println(message); // Simply log to console
    }

    @Override
    public void archive(){

    }
}

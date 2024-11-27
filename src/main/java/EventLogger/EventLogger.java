package EventLogger;

import java.util.ArrayList;

public class EventLogger {
    // Private static instance, eagerly initialized (thread-safe)
    public static final EventLogger instance = new EventLogger();

    private ArrayList<ILogger> loggers;

    private EventLogger() {
        loggers = new ArrayList<>();
    }

    public void log(LogLevel level, String message) {
        for (ILogger logger : loggers) {
            logger.log(level + ": " + message);
        }
    }

    public void LogInfo(String message){
        log(LogLevel.INFO, message);
    }
    public void LogDebug(String message){
        log(LogLevel.DEBUG, message);
    }
    public void LogError(String message){
        log(LogLevel.ERROR, message);
    }

    public void archive(){
        for (ILogger logger : loggers) {
            logger.archive();
        }
    }

}
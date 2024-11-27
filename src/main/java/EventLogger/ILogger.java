package EventLogger;

public interface ILogger {
    void log(String message);

    void archive();
}

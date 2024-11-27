package EventLogger;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        EventLogger logger = EventLogger.instance;

        logger.addLogger(new LogToConsole());
        logger.addLogger(new LogToFile("LoggerOutput"));

        awaitPlayerInput();
        logger.archive();
    }

    private static void awaitPlayerInput(){
        Scanner scanner = new Scanner(System.in);
        LogLevel level = selectSecurityType(scanner);
        System.out.println("Enter your message to log");
        String message = scanner.nextLine();

        EventLogger.instance.log(level, message);

        System.out.println("Log another message? Y/N");
        if(!Objects.equals(scanner.nextLine().toLowerCase(), "n")) awaitPlayerInput();
    }

    private static LogLevel selectSecurityType(Scanner scanner){
        System.out.println("Please select a security level: INFO, DEBUG, ERROR");
        return switch (scanner.nextLine().toLowerCase().trim()) {
            case "info" -> LogLevel.INFO;
            case "debug" -> LogLevel.DEBUG;
            case "error" -> LogLevel.ERROR;
            default -> selectSecurityType(scanner);
        };
    }
}

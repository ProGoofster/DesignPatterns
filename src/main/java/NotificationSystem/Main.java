package NotificationSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<INotification> notificationList = new ArrayList<>();
        while(true){
            System.out.println("Please select a notification type to add:");
            System.out.print("Currently Selected: ");
            for(INotification notification : notificationList){
                System.out.print(notification.getNotificationType());
                if(notificationList.size() - 1 != notificationList.indexOf(notification)){
                    System.out.print(", ");
                }
            }
            System.out.println("\nA. SMS");
            System.out.println("B. EMail");
            System.out.println("C. Slack");
            System.out.println("D. Confirm Selections");

            String selection = scanner.next().toLowerCase();

            if(selection.matches("d")) break;
            if(selection.matches("^(?![abc]$).+")) continue;

            notificationList.add(switch (selection) {
                case "a" -> new SMSNotification();
                case "b" -> new EmailNotification();
                case "c" -> new SlackNotification();
                default -> throw new IllegalStateException("Unexpected value: " + selection);
            });
        }

        for(INotification notification : notificationList){
            notification.sendNotification("Notification test!");
        }
    }
}

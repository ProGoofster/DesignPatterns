package NotificationSystem;

public class SMSNotification implements INotification {
    public final String notificationType = "SMS";
    @Override
    public void sendNotification(String message) {
        System.out.println(notificationType + " notification received: " + message);
    }

    @Override
    public String getNotificationType() {
        return notificationType;
    }
}

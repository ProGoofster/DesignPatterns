package NotificationSystem;

public class EmailNotification implements INotification {

    public final String notificationType = "Email";
    @Override
    public void sendNotification(String message) {
        System.out.println(notificationType + " notification received: " + message);
    }

    @Override
    public String getNotificationType() {
        return notificationType;
    }
}

package NotificationSystem;

public class SlackNotification implements INotification {
    public final String notificationType = "Slack";
    @Override
    public void sendNotification(String message) {
        System.out.println(notificationType + " notification received: " + message);
    }

    @Override
    public String getNotificationType() {
        return notificationType;
    }
}

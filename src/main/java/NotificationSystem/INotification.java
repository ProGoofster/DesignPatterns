package NotificationSystem;

public interface INotification {
    void sendNotification(String message);
    String getNotificationType();
}

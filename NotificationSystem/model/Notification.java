package NotificationSystem.model;

import java.util.Objects;

public class Notification {
    
    private final String recipient;
    private final String subject;
    private final String message;
    private final NotificationChannel notificationChannel;

    public Notification(String recipient, String subject, String message, NotificationChannel notificationChannel) {
        this.recipient = Objects.requireNonNull(recipient);
        this.subject = subject;
        this.message = Objects.requireNonNull(message);
        this.notificationChannel = Objects.requireNonNull(notificationChannel);
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public NotificationChannel getNotificationChannel() {
        return notificationChannel;
    }

    
    



}

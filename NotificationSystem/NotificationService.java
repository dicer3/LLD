package NotificationSystem;

import java.util.Objects;


import NotificationSystem.model.NotificationFactory;
import NotificationSystem.model.Notification;
import NotificationSystem.model.NotificationSender;

public class NotificationService {
    
    private final NotificationFactory notificationFactory;

    public NotificationService(NotificationFactory factory){
        this.notificationFactory = Objects.requireNonNull(factory);
    }

    public void sendNotification(Notification notification){
        NotificationSender sender = notificationFactory.getSender(notification.getNotificationChannel());

        try {
            sender.send(notification);
        } catch (RuntimeException e){
           System.err.println(
            "Notification failed "+e.getMessage()
           );
           throw e;
        }
    }
}

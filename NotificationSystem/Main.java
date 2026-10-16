package NotificationSystem;

import NotificationSystem.model.NotificationChannel;
import NotificationSystem.model.NotificationFactory;
import NotificationSystem.model.Notification;

public class Main {
    public static void main(String[] args) {
        
        NotificationFactory factory = new NotificationFactory();

        NotificationService service = new NotificationService(factory);

        Notification email = new Notification("user@example.com", 
        "Order confirmed",
         "Your Order has been confirmed", 
          NotificationChannel.EMAIL
        );

        Notification push = new Notification("device-token-123", 
         null,
         "Your Order has been shipped", 
          NotificationChannel.PUSH
        );

        Notification sms = new Notification("919876543210",
            null,
            "Your OTP is 123456.",
            NotificationChannel.SMS
        );

        service.sendNotification(email);
        service.sendNotification(push);
        service.sendNotification(sms);
    }
}

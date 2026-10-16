package NotificationSystem.model;

public class NotificationFactory {
    
    public NotificationSender getSender(NotificationChannel notificationChannel){

        return switch(notificationChannel){
            case EMAIL -> new EmailSender();
            case SMS -> new SmsSender();
            case PUSH -> new PushSender();
        };
    }
}

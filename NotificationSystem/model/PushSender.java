package NotificationSystem.model;

public class PushSender implements  NotificationSender {

    @Override
    public void send(Notification notification) {

        System.out.println("Sending PUSH notification "+notification.getRecipient());

        System.out.println("Message "+notification.getMessage());
    }
        
}

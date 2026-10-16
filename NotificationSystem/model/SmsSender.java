package NotificationSystem.model;

public class SmsSender implements NotificationSender{

    @Override
    public void send(Notification notification) {
        // TODO Auto-generated method stub

        System.out.println("Sending SMS to "+notification.getRecipient());

        System.out.println("Message :"+notification.getMessage());
    }

    
}

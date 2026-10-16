package NotificationSystem.model;

public class EmailSender implements NotificationSender {

    @Override
    public void send(Notification notification) {
        // TODO Auto-generated method stub
        
        System.out.println("Sending EMAIL to "+notification.getRecipient());

        System.out.println("Subject: "+notification.getSubject());

        System.out.println("Message :"+notification.getMessage());
    }
    
    
}

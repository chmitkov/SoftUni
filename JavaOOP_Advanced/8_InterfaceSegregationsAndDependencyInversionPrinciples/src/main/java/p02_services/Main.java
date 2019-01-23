package p02_services;

public class Main {
    public static void main(String[] args) {
        NotificationService emailNotif = new EmailNotificationService(true);
        NotificationService smsNotif = new SmsNotificationService(true);

        OnlineStoreOrder onlineStoreOrder =
                new OnlineStoreOrder(emailNotif, smsNotif, emailNotif);

        onlineStoreOrder.process();
    }
}

package p02_services;

public abstract class BaseNotificationService implements NotificationService {
    private boolean isActive;


    public BaseNotificationService(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }

    @Override
    public void notificationService() {
        System.out.println(String.format("%s notification was send",
                this.getClass().getSimpleName()));
    }
}

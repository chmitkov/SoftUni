package p02_services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnlineStoreOrder {

    private List<NotificationService> notificationServices;

    public OnlineStoreOrder(NotificationService... notifs) {
        this.notificationServices = new ArrayList<>();
        this.notificationServices.addAll(Arrays.asList(notifs));
    }

    public void process() {
        this.notificationServices
                .forEach(NotificationService::notificationService);
    }
}

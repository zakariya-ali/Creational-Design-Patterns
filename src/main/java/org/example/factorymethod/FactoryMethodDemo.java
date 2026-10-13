package org.example.factorymethod;

/**
 * FACTORY METHOD
 * Problem: the client shouldn't hard-code "new EmailNotification()" everywhere.
 * Solution: a creator class declares a factory method; subclasses decide which
 * concrete product to create. The client only knows the Notification interface.
 */
interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    public void send(String message) { System.out.println("Email: " + message); }
}

class SmsNotification implements Notification {
    public void send(String message) { System.out.println("SMS: " + message); }
}

// Creator: contains business logic and delegates object creation to subclasses
abstract class NotificationService {
    protected abstract Notification createNotification(); // <-- the factory method

    public void notifyUser(String message) {
        Notification notification = createNotification();
        notification.send(message);
    }
}

class EmailService extends NotificationService {
    protected Notification createNotification() { return new EmailNotification(); }
}

class SmsService extends NotificationService {
    protected Notification createNotification() { return new SmsNotification(); }
}

public class FactoryMethodDemo {
    public static void run() {
        System.out.println("=== Factory Method ===");
        NotificationService service = new EmailService();
        service.notifyUser("Your order has shipped");

        service = new SmsService(); // swap the product without changing notifyUser()
        service.notifyUser("Your OTP is 1234");
    }
}

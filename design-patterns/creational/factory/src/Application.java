// Main
public class Application {
    public static void main(String[] args) {
        NotificationFactory notification;

        // Email
        notification = new EmailNotificationFactory();
        notification.send("Welcome to the world of Java");

        // Push
        notification = new PushNotificationFactory();
        notification.send("You won the game");
    }

}
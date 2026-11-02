package oop.interface_demo;

public class InterfaceDemo {
    interface Notifier {
        void send(String message);
    }

    static class EmailNotifier implements Notifier {
        @Override public void send(String message) {
            System.out.println("Email mô phỏng: " + message);
        }
    }

    static class SmsNotifier implements Notifier {
        @Override public void send(String message) {
            System.out.println("SMS mô phỏng: " + message);
        }
    }

    static void notifyUser(Notifier notifier) {
        notifier.send("Chào bạn");
    }

    public static void main(String[] args) {
        // Đoán output; notifyUser có biết class cụ thể của notifier không?
        notifyUser(new EmailNotifier());
        notifyUser(new SmsNotifier());
    }
}

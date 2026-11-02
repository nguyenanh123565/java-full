package oop.interface_demo;

public class InterfaceSolution {
    interface Printer { void print(String text); }

    static class ConsolePrinter implements Printer {
        @Override public void print(String text) { System.out.println(text); }
    }

    interface Notifier { void send(String message); }

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

    static void sendWelcome(Notifier notifier) { notifier.send("Chào bạn"); }

    interface Drawable { void draw(); }
    interface Resizable { void resize(double factor); }

    static class Rectangle implements Drawable, Resizable {
        private double width;
        private double height;

        Rectangle(double width, double height) {
            this.width = positive(width);
            this.height = positive(height);
        }

        private static double positive(double value) {
            if (!Double.isFinite(value) || value <= 0) {
                throw new IllegalArgumentException("Giá trị phải hữu hạn và dương");
            }
            return value;
        }

        @Override public void draw() {
            System.out.println("Rectangle " + width + " x " + height);
        }

        @Override public void resize(double factor) {
            positive(factor);
            double nextWidth = positive(width * factor);
            double nextHeight = positive(height * factor);
            width = nextWidth;
            height = nextHeight; // Chỉ đổi trạng thái sau khi kiểm tra cả hai.
        }
    }

    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        printer.print("Java Core");

        sendWelcome(new EmailNotifier());
        sendWelcome(new SmsNotifier());

        Rectangle rectangle = new Rectangle(3, 4);
        Drawable drawable = rectangle;
        Resizable resizable = rectangle;
        drawable.draw();
        resizable.resize(2);
        drawable.draw();
        System.out.println("Cùng object: " + (drawable == resizable));
        // Interface giới hạn các hành vi được nhìn thấy qua mỗi reference.
    }
}

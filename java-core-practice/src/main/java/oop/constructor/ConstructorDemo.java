package oop.constructor;

public class ConstructorDemo {
    static class Book {
        final String title;

        Book() {
            this("Chưa đặt tên"); // Gọi constructor khác của cùng class.
            System.out.println("Constructor không tham số");
        }

        Book(String title) {
            this.title = title;
            System.out.println("Constructor có tham số: " + title);
        }
    }

    public static void main(String[] args) {
        // Đoán thứ tự output và số object Book được tạo.
        Book a = new Book();
        Book b = new Book("Java Core");
        System.out.println(a.title);
        System.out.println(b.title);
    }
}

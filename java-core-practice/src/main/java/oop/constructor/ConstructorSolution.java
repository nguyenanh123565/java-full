package oop.constructor;

public class ConstructorSolution {
    static class Book {
        final String title;

        Book() { this("Chưa đặt tên"); }
        Book(String title) { this.title = title; }
    }

    static class Product {
        final String name;
        final long price;

        Product(String name) { this(name, 0); }

        Product(String name, long price) {
            if (price < 0) {
                throw new IllegalArgumentException("Giá phải không âm");
            }
            this.name = name;
            this.price = price;
        }
    }

    static class Student {
        String name;
        int age;

        Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        Student(Student other) {
            this(other.name, other.age);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Book().title);
        System.out.println(new Book("Java Core").title);

        // Constructor chaining giữ kiểm tra dữ liệu tại một chỗ.
        System.out.println(new Product("Bút").price);
        System.out.println(new Product("Vở", 15_000).price);
        try {
            new Product("Sai giá", -1);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        Student original = new Student("An", 20);
        Student copy = new Student(original);
        copy.age = 21;
        System.out.println("Cùng object: " + (original == copy));
        System.out.println(original.age + " / " + copy.age);
        // Copy constructor là quy ước tự viết, Java không tự cung cấp.
        // Nếu có field mutable như List, cần quyết định sao chép List thế nào.
    }
}

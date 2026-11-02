package oop.abstraction;

public class AbstractionSolution {
    abstract static class Shape {
        abstract double area();
        static double positive(double value) {
            if (!Double.isFinite(value) || value <= 0) {
                throw new IllegalArgumentException("Kích thước phải hữu hạn và dương");
            }
            return value;
        }
    }

    static class Rectangle extends Shape {
        private final double width;
        private final double height;
        Rectangle(double width, double height) {
            this.width = positive(width);
            this.height = positive(height);
        }
        @Override double area() { return width * height; }
    }

    static class Circle extends Shape {
        private final double radius;
        Circle(double radius) { this.radius = positive(radius); }
        @Override double area() { return Math.PI * radius * radius; }
    }

    abstract static class Report {
        final void printReport() {
            System.out.println("=== Báo cáo ===");
            System.out.println(body());
            System.out.println("=== Kết thúc ===");
        }
        abstract String body();
    }

    static class StudentReport extends Report {
        @Override String body() { return "Sinh viên An, điểm 8"; }
    }

    public static void main(String[] args) {
        System.out.println(new Rectangle(3, 4).area());
        try {
            new Rectangle(0, 4);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        Shape[] shapes = {new Rectangle(3, 4), new Circle(2)};
        double total = 0;
        for (Shape shape : shapes) {
            total += shape.area();
        }
        System.out.println("Tổng diện tích: " + total);
        // Vòng lặp chỉ phụ thuộc hợp đồng area của Shape.

        new StudentReport().printReport();
        // final giữ quy trình chung; body là phần cho phép lớp con thay đổi.
    }
}

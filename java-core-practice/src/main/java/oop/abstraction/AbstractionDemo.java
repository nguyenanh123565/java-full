package oop.abstraction;

public class AbstractionDemo {
    abstract static class Shape {
        abstract double area();

        void describe() { System.out.println("Diện tích: " + area()); }
    }

    static class Rectangle extends Shape {
        private final double width;
        private final double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override double area() { return width * height; }
    }

    public static void main(String[] args) {
        // Đoán output. Vì sao không thể viết new Shape()?
        Shape shape = new Rectangle(3, 4);
        shape.describe();
    }
}

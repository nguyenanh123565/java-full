package oop.composition;

public class CompositionDemo {
    static class Engine {
        void start() { System.out.println("Engine khởi động"); }
    }

    static class Car {
        private final Engine engine = new Engine();

        void drive() {
            engine.start(); // Car sử dụng Engine, không phải là một Engine.
            System.out.println("Car di chuyển");
        }
    }

    public static void main(String[] args) {
        // Đoán thứ tự output và đếm object Car/Engine trước khi chạy.
        Car car = new Car();
        Car sameCar = car;
        sameCar.drive();
        System.out.println(car == sameCar);
    }
}

package oop.polymorphism;

public class PolymorphismDemo {
    static class Animal {
        String speak() { return "Âm thanh của động vật"; }
    }

    static class Dog extends Animal {
        @Override String speak() { return "Gâu"; }
    }

    static class Cat extends Animal {
        @Override String speak() { return "Meo"; }
    }

    public static void main(String[] args) {
        // Đoán output: kiểu biến là Animal, vậy method nào thực sự chạy?
        Animal[] animals = {new Dog(), new Cat()};
        for (Animal animal : animals) {
            System.out.println(animal.speak());
        }
        // Các reference có chung kiểu khai báo, object thực tế có thể khác kiểu.
    }
}

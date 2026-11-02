package oop.polymorphism;

public class PolymorphismSolution {
    static class Animal {
        String speak() { return "Âm thanh của động vật"; }
    }

    static class Dog extends Animal {
        @Override String speak() { return "Gâu"; }
        void fetch() { System.out.println("Dog nhặt bóng"); }
    }

    static class Cat extends Animal {
        @Override String speak() { return "Meo"; }
    }

    abstract static class Payment {
        abstract void pay(long amount);
        void validate(long amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Số tiền phải dương");
            }
        }
    }

    static class CashPayment extends Payment {
        @Override void pay(long amount) {
            validate(amount);
            System.out.println("Tiền mặt: " + amount);
        }
    }

    static class CardPayment extends Payment {
        @Override void pay(long amount) {
            validate(amount);
            System.out.println("Thẻ mô phỏng: " + amount);
        }
    }

    static void checkout(Payment payment, long amount) {
        payment.pay(amount); // Dispatch chọn cài đặt của object thực tế.
    }

    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat()};
        for (Animal animal : animals) {
            System.out.println(animal.speak());
        }

        checkout(new CashPayment(), 50_000);
        checkout(new CardPayment(), 80_000);
        try {
            checkout(new CashPayment(), -1);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                ((Dog) animal).fetch();
            }
        }
        Animal cat = new Cat();
        try {
            Dog dog = (Dog) cat;
            dog.fetch();
        } catch (ClassCastException ex) {
            System.out.println("Object Cat không thể ép thành Dog");
        }
        // Cast chỉ đổi góc nhìn kiểu reference, không đổi kiểu object.
    }
}

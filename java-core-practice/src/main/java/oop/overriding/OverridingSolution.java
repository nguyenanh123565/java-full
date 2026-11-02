package oop.overriding;

public class OverridingSolution {
    static class Animal {
        String speak() { return "Âm thanh chung"; }
    }

    static class Dog extends Animal {
        @Override String speak() { return "Gâu"; }
    }

    static class Parent {
        String describe() { return "Parent"; }
    }

    static class Child extends Parent {
        @Override String describe() { return super.describe() + " + Child"; }
    }

    static class Base {
        String label = "Base field";
        static String kind() { return "Base static"; }
        String getLabel() { return label; }
    }

    static class SpecialChild extends Base {
        String label = "Child field";
        static String kind() { return "Child static"; }
        @Override String getLabel() { return label; }
    }

    public static void main(String[] args) {
        Animal animal = new Dog();
        System.out.println(animal.speak());

        Parent parent = new Child();
        System.out.println(parent.describe());
        // super.describe() gọi trực tiếp cài đặt cha; không quay lại Child.

        Base base = new SpecialChild();
        System.out.println(base.label); // Field chọn theo kiểu reference khai báo.
        System.out.println(base.getLabel()); // Instance method dispatch lúc chạy.
        System.out.println(Base.kind());
        System.out.println(SpecialChild.kind());
        // Static method được hide, không override; nên gọi bằng tên class.
        // SpecialChild là Child của bài 3, đổi tên để tránh trùng Child bài 2.
    }
}

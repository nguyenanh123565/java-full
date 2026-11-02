package oop.overriding;

public class OverridingDemo {
    static class Parent {
        String describe() { return "Parent"; }
    }

    static class Child extends Parent {
        @Override String describe() {
            return super.describe() + " + Child";
        }
    }

    public static void main(String[] args) {
        // Đoán output; vì sao kiểu biến Parent không buộc chạy Parent.describe()?
        Parent parent = new Parent();
        Parent child = new Child();
        System.out.println(parent.describe());
        System.out.println(child.describe());
        // super chọn cài đặt lớp cha trong method của lớp con.
    }
}

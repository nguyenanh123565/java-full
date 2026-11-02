package oop.class_object;

public class ClassObjectSolution {
    static class Student {
        String name;
        int age;

        void introduce() {
            System.out.println(name + ", " + age + " tuổi");
        }
    }

    public static void main(String[] args) {
        // Bài 1: Mỗi lần new tạo một object với các field riêng.
        Student first = new Student();
        first.name = "An";
        first.age = 20;
        Student second = new Student();
        second.name = "Bình";
        second.age = 21;
        first.introduce();
        second.introduce();

        // Bài 2: a và b là hai biến cùng giữ reference tới first.
        Student a = first;
        Student b = a;
        b.age = 22;
        System.out.println("a.age = " + a.age);
        System.out.println("a == b: " + (a == b));

        // Bài 3: c có identity riêng; age primitive được sao chép giá trị.
        Student c = new Student();
        c.name = a.name; // String immutable nên có thể chia sẻ reference này.
        c.age = a.age;
        c.age = 30;
        System.out.println("a.age = " + a.age + ", c.age = " + c.age);
        System.out.println("a == c: " + (a == c));
        // Có ba object Student; số object String là một câu hỏi khác.
    }
}

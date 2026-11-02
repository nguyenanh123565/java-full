package oop.inheritance;

public class InheritanceDemo {
    static class Person {
        private final String name;

        Person(String name) {
            this.name = name;
            System.out.println("Khởi tạo Person");
        }

        String getName() { return name; }
    }

    static class Teacher extends Person {
        Teacher(String name) {
            super(name);
            System.out.println("Khởi tạo Teacher");
        }
    }

    public static void main(String[] args) {
        // Đoán thứ tự output; có bao nhiêu object Teacher được tạo?
        Teacher teacher = new Teacher("Mai");
        Person person = teacher;
        System.out.println(person.getName());
        System.out.println(person == teacher);
    }
}

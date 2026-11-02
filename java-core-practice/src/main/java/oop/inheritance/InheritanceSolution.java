package oop.inheritance;

public class InheritanceSolution {
    static class Person {
        private final String name;
        Person(String name) { this.name = name; }
        String getName() { return name; }
    }

    static class Teacher extends Person {
        private final String subject;
        Teacher(String name, String subject) {
            super(name);
            this.subject = subject;
        }
        void introduce() { System.out.println(getName() + " dạy " + subject); }
    }

    static class Employee {
        private final String name;
        Employee(String name) { this.name = name; }
        String getName() { return name; }
        long calculateSalary() { return 0; }
    }

    static class FullTimeEmployee extends Employee {
        private final long monthlySalary;
        FullTimeEmployee(String name, long monthlySalary) {
            super(name);
            if (monthlySalary < 0) {
                throw new IllegalArgumentException("Lương phải không âm");
            }
            this.monthlySalary = monthlySalary;
        }
        @Override long calculateSalary() { return monthlySalary; }
    }

    static class Base {
        Base(String name) { System.out.println("Base: " + name); }
    }

    static class Child extends Base {
        Child() {
            super("phần trạng thái lớp cha");
            System.out.println("Child");
        }
    }

    public static void main(String[] args) {
        new Teacher("Mai", "Toán").introduce();

        Employee employee = new FullTimeEmployee("An", 12_000_000);
        System.out.println(employee.getName() + ": " + employee.calculateSalary());
        // Method instance được chọn theo object thực tế FullTimeEmployee.

        Child child = new Child();
        Base base = child;
        System.out.println("Cùng object: " + (base == child));
        // super khởi tạo phần trạng thái kế thừa trong cùng object Child.
    }
}

package oop.composition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CompositionSolution {
    static class Engine {
        void start() { System.out.println("Engine khởi động"); }
    }

    static class Car {
        private final Engine engine = new Engine();
        void drive() {
            engine.start();
            System.out.println("Car di chuyển");
        }
    }

    interface MessageSender { void send(String message); }

    static class ConsoleSender implements MessageSender {
        @Override public void send(String message) { System.out.println(message); }
    }

    static class LoudSender implements MessageSender {
        @Override public void send(String message) {
            System.out.println("!!! " + message + " !!!");
        }
    }

    static class NotificationService {
        private final MessageSender sender;
        NotificationService(MessageSender sender) {
            this.sender = Objects.requireNonNull(sender, "sender");
        }
        void notifyUser(String message) { sender.send(message); }
    }

    static class Student {
        private String name;
        Student(String name) { this.name = Objects.requireNonNull(name, "name"); }
        String getName() { return name; }
        void setName(String name) { this.name = Objects.requireNonNull(name, "name"); }
    }

    static class Classroom {
        private final List<Student> students = new ArrayList<>();
        void addStudent(Student student) {
            students.add(Objects.requireNonNull(student, "student"));
        }
        List<Student> getStudents() { return new ArrayList<>(students); }
    }

    public static void main(String[] args) {
        new Car().drive(); // Một Car và một Engine; không có quan hệ is-a.

        new NotificationService(new ConsoleSender()).notifyUser("Chào bạn");
        new NotificationService(new LoudSender()).notifyUser("Chào bạn");
        // Đây là truyền dependency qua constructor bằng Java thuần.

        Classroom classroom = new Classroom();
        classroom.addStudent(new Student("An"));
        List<Student> copy = classroom.getStudents();
        copy.clear();
        System.out.println("Số sinh viên nội bộ: " + classroom.getStudents().size());
        List<Student> anotherCopy = classroom.getStudents();
        anotherCopy.get(0).setName("Bình");
        System.out.println(classroom.getStudents().get(0).getName());
        // Sao chép List bảo vệ cấu trúc List, không sao chép object Student.
        // Nếu cần cô lập cả phần tử: dùng Student immutable hoặc copy từng object.
    }
}

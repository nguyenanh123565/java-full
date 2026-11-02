package oop.encapsulation;

public class EncapsulationSolution {
    static class Student {
        private int age;

        int getAge() { return age; }

        void setAge(int age) {
            if (age < 0 || age > 150) {
                throw new IllegalArgumentException("Tuổi phải từ 0 đến 150");
            }
            this.age = age;
        }
    }

    static class Wallet {
        private long balance;

        long getBalance() { return balance; }

        void deposit(long amount) {
            checkPositive(amount);
            balance = Math.addExact(balance, amount);
        }

        void withdraw(long amount) {
            checkPositive(amount);
            if (amount > balance) {
                throw new IllegalArgumentException("Không đủ số dư");
            }
            balance -= amount;
        }

        private void checkPositive(long amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Số tiền phải dương");
            }
        }
    }

    static class Scores {
        private final int[] values;

        Scores(int[] values) { this.values = values.clone(); }
        int[] getValues() { return values.clone(); }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(20);
        try {
            student.setAge(-1);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(student.getAge());

        Wallet wallet = new Wallet();
        wallet.deposit(100_000);
        wallet.withdraw(30_000);
        try {
            wallet.withdraw(80_000);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(wallet.getBalance());

        int[] input = {8, 9};
        Scores scores = new Scores(input);
        input[0] = 0;
        int[] output = scores.getValues();
        output[0] = 1;
        System.out.println(scores.getValues()[0]);
        // clone đủ cho int[]: các phần tử primitive không chia sẻ object mutable.
        // Với Object[], clone chỉ sao chép array, vẫn chia sẻ reference phần tử.
    }
}

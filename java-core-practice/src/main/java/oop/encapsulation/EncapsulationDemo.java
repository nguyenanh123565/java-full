package oop.encapsulation;

public class EncapsulationDemo {
    static class Wallet {
        private long balance;

        void deposit(long amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Số tiền phải dương");
            }
            balance += amount;
        }

        long getBalance() { return balance; }
    }

    public static void main(String[] args) {
        // Đoán output trước khi chạy. Vì sao không cho sửa balance trực tiếp?
        Wallet wallet = new Wallet();
        wallet.deposit(100_000);
        try {
            wallet.deposit(-20_000);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(wallet.getBalance());
    }
}

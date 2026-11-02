package exception.custom_exception;

public class CustomExceptionSolution {
    public static void main(String[] args) {
        try {
            System.out.println("Bài 1, số dư mới: " + withdraw(100, 40));
            withdraw(100, 150);
        } catch (InsufficientFundsException e) {
            System.out.println("Bài 1: " + e.getMessage());
        }

        Account validation = new Account(100);
        for (long amount : new long[]{0, -10}) {
            try {
                validation.withdraw(amount);
            } catch (IllegalArgumentException e) {
                System.out.println("Bài 2: " + e.getMessage());
            } catch (InsufficientFundsException e) {
                throw new IllegalStateException("Dữ liệu mẫu đáng lẽ không vào nhánh này", e);
            }
        }
        try {
            new Account(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Bài 2, constructor: " + e.getMessage());
        }

        Account account = new Account(100);
        for (long amount : new long[]{30, 100, 20}) {
            try {
                account.withdraw(amount);
                System.out.println("Bài 3, rút thành công: " + amount);
            } catch (InsufficientFundsException e) {
                System.out.println("Bài 3, yêu cầu " + e.getAmountRequested()
                        + ", số dư hiện tại " + e.getCurrentBalance());
            }
            System.out.println("Số dư: " + account.getBalance()); // 70, 70, 50.
        }
    }

    private static long withdraw(long balance, long amount) throws InsufficientFundsException {
        if (balance < 0) throw new IllegalArgumentException("Số dư không được âm");
        if (amount <= 0) throw new IllegalArgumentException("Số tiền phải dương");
        if (amount > balance) throw new InsufficientFundsException(amount, balance);
        return balance - amount; // Chỉ cập nhật sau khi kiểm tra mọi điều kiện.
    }

    private static final class Account {
        private long balance;

        private Account(long balance) {
            if (balance < 0) throw new IllegalArgumentException("Số dư không được âm");
            this.balance = balance;
        }

        private void withdraw(long amount) throws InsufficientFundsException {
            balance = CustomExceptionSolution.withdraw(balance, amount);
            // Nếu helper ném lỗi, phép gán không xảy ra.
        }

        private long getBalance() {
            return balance;
        }
    }

    private static final class InsufficientFundsException extends Exception {
        private static final long serialVersionUID = 1L;
        private final long amountRequested;
        private final long currentBalance;

        private InsufficientFundsException(long amountRequested, long currentBalance) {
            super("Không đủ số dư: yêu cầu " + amountRequested + ", hiện có " + currentBalance);
            this.amountRequested = amountRequested;
            this.currentBalance = currentBalance;
        }

        private long getAmountRequested() {
            return amountRequested;
        }

        private long getCurrentBalance() {
            return currentBalance;
        }
    }
}

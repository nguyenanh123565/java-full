package exception.custom_exception;

public class CustomExceptionDemo {
    public static void main(String[] args) {
        long balance = 100; // Đơn vị nhỏ nhất của tiền, tránh sai số dấu phẩy động.
        // Đoán output và giải thích vì sao balance giữ nguyên khi rút thất bại.
        try {
            balance = withdraw(balance, 150);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(balance);
    }

    private static long withdraw(long balance, long amount) throws InsufficientFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Số tiền phải dương");
        if (amount > balance) throw new InsufficientFundsException("Không đủ số dư");
        return balance - amount;
    }

    private static final class InsufficientFundsException extends Exception {
        private static final long serialVersionUID = 1L;

        private InsufficientFundsException(String message) {
            super(message);
        }
    }
}

package enum_demo;

public class EnumDemo {
    enum Status { NEW, PAID, CANCELLED }

    public static void main(String[] args) {
        Status status = Status.NEW;
        // Dự đoán output: enum dùng kiểu riêng và == để so hằng số.
        System.out.println(status == Status.NEW);
        String message = switch (status) {
            case NEW -> "Chờ thanh toán";
            case PAID -> "Đã thanh toán";
            case CANCELLED -> "Đã hủy";
        };
        System.out.println(message);
    }
}

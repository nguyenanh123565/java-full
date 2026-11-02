package fundamental.condition;

public class ConditionDemo {
    public static void main(String[] args) {
        // Đoán nhánh nào chạy: chỉ nhánh đầu tiên thỏa điều kiện được chọn.
        int score = 8;
        if (score >= 8) {
            System.out.println("Giỏi");
        } else if (score >= 5) {
            System.out.println("Đạt");
        } else {
            System.out.println("Chưa đạt");
        }

        int number = 0;
        System.out.println(number > 0 ? "Dương" : "Không dương");

        int day = 2;
        // Switch expression có từ Java 14; mũi tên không bị fall-through.
        String name = switch (day) {
            case 1 -> "Thứ hai";
            case 2 -> "Thứ ba";
            default -> "Ngày khác";
        };
        System.out.println(name);
    }
}

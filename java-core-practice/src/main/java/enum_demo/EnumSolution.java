package enum_demo;

public class EnumSolution {
    public enum Severity {
        LOW(1), MEDIUM(2), HIGH(3);
        private final int priority;
        Severity(int priority) { this.priority = priority; }
        public int getPriority() { return priority; }
        public String message() {
            return switch (this) {
                case LOW -> "Theo dõi";
                case MEDIUM -> "Cần xử lý";
                case HIGH -> "Xử lý ngay";
            };
        }
    }

    public enum OrderStatus {
        NEW, PAID, SHIPPED, CANCELLED;
        public boolean canMoveTo(OrderStatus next) {
            return switch (this) {
                case NEW -> next == PAID || next == CANCELLED;
                case PAID -> next == SHIPPED;
                case SHIPPED, CANCELLED -> false;
            };
        }
    }

    public static void main(String[] args) {
        // Bài 1 + 2: dữ liệu priority có nghĩa riêng, không phụ thuộc vị trí khai báo.
        for (Severity level : Severity.values())
            System.out.println(level + ": " + level.message() + ", " + level.getPriority());
        // Bài 3: quy tắc chuyển trạng thái nằm cùng kiểu trạng thái.
        System.out.println(OrderStatus.NEW.canMoveTo(OrderStatus.SHIPPED));
        System.out.println(OrderStatus.PAID.canMoveTo(OrderStatus.SHIPPED));
        System.out.println(OrderStatus.SHIPPED.canMoveTo(OrderStatus.NEW));
    }
}

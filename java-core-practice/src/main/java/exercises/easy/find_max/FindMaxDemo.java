package exercises.easy.find_max;

public class FindMaxDemo {
    public static void main(String[] args) {
        int current = -7;
        int candidate = -2;
        // Dự đoán output: so sánh dữ liệu thực, không khởi tạo ứng viên bằng 0.
        System.out.println(candidate > current);
        System.out.println(Integer.compare(candidate, current));
    }
}

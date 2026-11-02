package exercises.easy.palindrome;

public class PalindromeDemo {
    public static void main(String[] args) {
        String text = "level";
        int left = 0, right = text.length() - 1;
        // Dự đoán output: chỉ so cặp đầu-cuối, chưa kiểm tra toàn chuỗi.
        System.out.println(text.charAt(left) == text.charAt(right));
        System.out.println('A' == 'a'); // Bài này phân biệt hoa/thường.
        System.out.println(text); // Đọc charAt không đổi String.
    }
}

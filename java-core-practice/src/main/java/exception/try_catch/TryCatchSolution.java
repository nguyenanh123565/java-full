package exception.try_catch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.UncheckedIOException;

public class TryCatchSolution {
    public static void main(String[] args) {
        System.out.println("Bài 1: " + parseOrDefault("12", 0));
        System.out.println("Bài 1: " + parseOrDefault("abc", 0));

        divideText("6", "2");
        divideText("6", "0");
        divideText("six", "2");

        try {
            System.out.println("Bài 3, tổng: " + sumLines("1\n2\n3"));
            System.out.println("Tổng: " + sumLines("1\nx\n3"));
        } catch (NumberFormatException e) {
            System.out.println("Bài 3: gặp dòng không phải số; reader đã được close.");
        } catch (IOException e) {
            // Giữ nguyên nguyên nhân thay vì bỏ qua lỗi I/O.
            throw new UncheckedIOException("Không đọc được dữ liệu", e);
        }
    }

    private static int parseOrDefault(String text, int fallback) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return fallback; // Theo yêu cầu API: dữ liệu lỗi có giá trị thay thế rõ ràng.
        }
    }

    private static void divideText(String left, String right) {
        try {
            int numerator = Integer.parseInt(left);
            int denominator = Integer.parseInt(right);
            System.out.println("Bài 2, kết quả: " + numerator / denominator);
        } catch (NumberFormatException e) {
            System.out.println("Bài 2: dữ liệu không phải số nguyên.");
        } catch (ArithmeticException e) {
            System.out.println("Bài 2: không thể chia số nguyên cho 0.");
        } finally {
            System.out.println("Hoàn tất");
        }
    }

    private static int sumLines(String text) throws IOException {
        // Khi rời block (return hoặc exception), try-with-resources gọi close().
        try (BufferedReader reader = new BufferedReader(new StringReader(text))) {
            int total = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                total += Integer.parseInt(line);
            }
            return total;
        }
    }
}

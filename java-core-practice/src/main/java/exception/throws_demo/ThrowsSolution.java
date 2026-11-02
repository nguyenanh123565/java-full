package exception.throws_demo;

import java.text.ParseException;

public class ThrowsSolution {
    public static void main(String[] args) {
        try {
            System.out.println("Bài 1: " + parseCount("12"));
            parseCount("abc");
        } catch (ParseException e) {
            System.out.println("Bài 1: " + e.getMessage());
            System.out.println("Cause: " + e.getCause().getClass().getSimpleName());
        }

        System.out.println("Bài 2: " + requirePositive(2));
        try {
            requirePositive(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Bài 2: " + e.getMessage());
        }

        for (String text : new String[]{"3", "abc", "-1"}) {
            try {
                System.out.println("Bài 3: " + parsePositiveCount(text));
            } catch (ParseException e) {
                System.out.println("Bài 3, lỗi định dạng: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Bài 3, lỗi giá trị: " + e.getMessage());
            }
        }
    }

    private static int parseCount(String text) throws ParseException {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            ParseException error = new ParseException("Số nguyên không hợp lệ: " + text, 0);
            error.initCause(e);
            throw error;
        }
    }

    private static int requirePositive(int value) {
        if (value <= 0) throw new IllegalArgumentException("Giá trị phải lớn hơn 0");
        return value;
    }

    private static int parsePositiveCount(String text) throws ParseException {
        return requirePositive(parseCount(text));
        // Checked exception truyền tới main; throws không phải block xử lý.
    }
}

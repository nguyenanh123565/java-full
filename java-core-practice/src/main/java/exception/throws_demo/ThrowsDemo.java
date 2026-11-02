package exception.throws_demo;

import java.text.ParseException;

public class ThrowsDemo {
    public static void main(String[] args) {
        // Đoán output: exception truyền từ parseCount tới caller nào?
        try {
            System.out.println(parseCount("12"));
            System.out.println(parseCount("abc"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int parseCount(String text) throws ParseException {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            ParseException error = new ParseException("Số nguyên không hợp lệ: " + text, 0);
            error.initCause(e); // Giữ lỗi gốc để chẩn đoán.
            throw error; // throw phát sinh exception; throws chỉ khai báo trách nhiệm caller.
        }
    }
}

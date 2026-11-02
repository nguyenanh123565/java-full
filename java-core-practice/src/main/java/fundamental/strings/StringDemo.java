package fundamental.strings;

public class StringDemo {
    public static void main(String[] args) {
        // Đoán từng dòng: String không bị sửa bởi concat.
        String text = "Java";
        String alias = text;
        text.concat(" Core"); // Kết quả trả về chưa được dùng.
        System.out.println(text);

        text = text.concat(" Core"); // Gán biến sang chuỗi kết quả.
        System.out.println(text);
        System.out.println(alias);

        String separate = new String("Java");
        System.out.println(alias == separate); // So sánh danh tính object.
        System.out.println(alias.equals(separate)); // So sánh nội dung.

        StringBuilder builder = new StringBuilder("Java");
        StringBuilder builderAlias = builder;
        builder.append(" Core"); // StringBuilder có thể thay đổi nội dung.
        System.out.println(builderAlias);
    }
}

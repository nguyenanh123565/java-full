package fundamental.strings;

public class StringSolution {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

for (int i = 0; i < 1000; i++) {
    sb.append(i);
}

String result = sb.toString();
System.out.println(result);
//         System.out.println("Bài 1: chuẩn hóa tạo kết quả mới");
//         String original = "  java core  ";
//         String normalized = original.trim().toUpperCase(Locale.ROOT);
//         System.out.println(normalized);       // JAVA CORE
//         System.out.println("[" + original + "]"); // [  java core  ]

//         System.out.println("Bài 2: danh tính và nội dung");
//         String literal = "Java";
//         String alias = literal;
//         String separate = new String("Java");
//         System.out.println(literal == alias);       // true
//         System.out.println(literal == separate);    // false
//         System.out.println(literal.equals(separate)); // true

//         System.out.println("Bài 3: String và StringBuilder qua method");
//         String text = "Java";
//         tryAppend(text);
//         System.out.println(text); // Java
//         text = appended(text);
//         System.out.println(text); // Java Core

//         StringBuilder builder = new StringBuilder("Java");
//         appendMutable(builder);
//         System.out.println(builder); // Java Core
//         // StringBuilder mutable: bản sao tham chiếu dẫn đến cùng builder.
//     }

//     private static void tryAppend(String text) {
//         text = text + " Core"; // Chỉ đổi tham số, String gốc không bị sửa.
//     }

//     private static String appended(String text) {
//         return text + " Core";
//     }

//     private static void appendMutable(StringBuilder builder) {
//         builder.append(" Core");
    }
}

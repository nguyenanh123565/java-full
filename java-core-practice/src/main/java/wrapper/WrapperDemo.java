package wrapper;

import java.util.ArrayList;
import java.util.List;

public class WrapperDemo {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127; // Autoboxing hằng trong [-128,127] có bảo đảm identity.
        // Dự đoán output; không suy rộng == cho mọi giá trị wrapper.
        System.out.println(a == b);
        System.out.println(Integer.valueOf(1000).equals(Integer.valueOf(1000)));
        List<Integer> values = new ArrayList<>(List.of(1, 2, 1));
        values.remove(1); // int chọn overload theo index.
        System.out.println(values);
    }
}

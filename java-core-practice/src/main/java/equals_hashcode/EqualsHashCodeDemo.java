package equals_hashcode;

import java.util.HashSet;
import java.util.Set;

public class EqualsHashCodeDemo {
    public static void main(String[] args) {
        String a = new String("Java");
        String b = new String("Java");
        Set<String> values = new HashSet<>();
        values.add(a);
        values.add(b);
        // Dự đoán output: hai new tạo hai String object khác identity.
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(values.size());
    }
}

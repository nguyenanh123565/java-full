package stream;

import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> values = List.of(1, 2, 3, 4);
        Stream<Integer> even = values.stream().filter(n -> n % 2 == 0);
        // Dự đoán hai dòng: pipeline chỉ được thực thi khi gọi sum().
        System.out.println(even.mapToInt(n -> n * n).sum());
        System.out.println(values); // Pipeline không sửa nguồn.
        // Không gọi terminal operation lần hai trên even.
    }
}

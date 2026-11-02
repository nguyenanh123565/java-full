package fundamental.reference;

public class ReferenceDemo {
    // Lớp nhỏ để quan sát object mutable; cú pháp lớp sẽ học kỹ ở OOP.
    private static class Box {
        int value;

        Box(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // Đoán giá trị của a, b và == sau mỗi bước.
        Box a = new Box(10);
        Box b = a; // Hai biến, một object Box.
        b.value = 20;
        System.out.println(a.value);
        System.out.println(a == b);

        b = new Box(30); // Chuyển b sang object khác, không sửa biến a.
        System.out.println(a.value + ", " + b.value);
        System.out.println(a == b);
        b = null; // Bỏ tham chiếu từ b; a vẫn tham chiếu Box ban đầu.
        System.out.println(a.value);
    }
}

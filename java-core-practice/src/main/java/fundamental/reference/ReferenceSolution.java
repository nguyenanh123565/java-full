package fundamental.reference;

public class ReferenceSolution {
    private static class Box {
        int value;

        Box(int value) {
            this.value = value;
        }
        // Không override equals: kế thừa so sánh danh tính từ Object.
    }

    public static void main(String[] args) {
        System.out.println("Bài 1: hai biến cùng object");
        Box a = new Box(10);
        Box b = a;
        b.value = 20;
        System.out.println(a.value); // 20
        System.out.println(a == b);  // true
        // Chỉ một biểu thức new Box ở bài 1: một Box theo ngữ nghĩa Java.

        System.out.println("Bài 2: cùng giá trị field, khác object");
        Box first = new Box(10);
        Box second = new Box(10);
        System.out.println(first == second);                // false
        System.out.println(first.equals(second));           // false
        System.out.println(first.value == second.value);    // true

        System.out.println("Bài 3: đổi tham số và đổi trạng thái");
        Box left = new Box(1);
        Box right = new Box(2);
        trySwap(left, right);
        System.out.println(left.value + ", " + right.value); // 1, 2
        swapValues(left, right);
        System.out.println(left.value + ", " + right.value); // 2, 1
    }

    private static void trySwap(Box left, Box right) {
        Box temporary = left;
        left = right;
        right = temporary;
        // Chỉ đổi bản sao tham chiếu của hai tham số.
    }

    private static void swapValues(Box left, Box right) {
        int temporary = left.value;
        left.value = right.value;
        right.value = temporary;
        // Hai tham số vẫn dẫn tới object caller, nên sửa field được nhìn thấy.
    }
}

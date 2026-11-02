package exercises.easy.binary_search;

public class BinarySearchDemo {
    public static void main(String[] args) {
        int left = 0, right = 4;
        int mid = left + (right - left) / 2;
        // Dự đoán output: sau khi bỏ nửa trái, khoảng tìm kiếm ngắn lại.
        System.out.println(mid);
        left = mid + 1;
        System.out.println(left + (right - left) / 2);
    }
}

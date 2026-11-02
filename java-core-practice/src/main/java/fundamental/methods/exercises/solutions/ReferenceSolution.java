package fundamental.methods.exercises.solutions;

public class ReferenceSolution {
    public static int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
    public static int add(int left, int right) { int result = left + right; left = 100; return result; }
    public static int magnitude(int value) { if (value < 0) return -value; return value; }
    public static int countMultiples(int from, int to, int divisor) {
        int count = 0;
        for (int i = from; i <= to; i++) if (i % divisor == 0) count++;
        return count;
    }
    public static long subtotal(int price, int quantity) { return 1L * price * quantity; }
    public static long discounted(long subtotal, int percent) { return subtotal - subtotal * percent / 100; }
    public static long invoice(int p1, int q1, int d1, int p2, int q2, int d2) {
        return discounted(subtotal(p1, q1), d1) + discounted(subtotal(p2, q2), d2);
    }
    public static void main(String[] args) {
        assert clamp(-2, 0, 10) == 0 && clamp(7, 0, 10) == 7 && clamp(12, 0, 10) == 10;
        assert clamp(0, 0, 10) == 0 && clamp(10, 0, 10) == 10 && clamp(8, 4, 4) == 4;
        assert clamp(-7, -10, -5) == -7;
        int n = 3; int result = add(n, n++); assert result == 6 && n == 4;
        n = -1; result = add(n, n++); assert result == -2 && n == 0;
        assert magnitude(-7) == 7 && magnitude(0) == 0 && magnitude(7) == 7;
        assert magnitude(-1_000_000) == 1_000_000 && magnitude(1_000_000) == 1_000_000;
        assert countMultiples(-3, 3, 2) == 3 && countMultiples(1, 10, 3) == 3;
        assert countMultiples(5, 4, 2) == 0 && countMultiples(0, 0, 100) == 1;
        assert countMultiples(1, 1, 2) == 0;
        assert invoice(2000, 3, 10, 10000, 2, 0) == 25_400;
        assert invoice(1, 0, 0, 100, 2, 100) == 0;
        assert invoice(1_000_000, 10_000, 0, 1_000_000, 10_000, 0) == 20_000_000_000L;
        System.out.println("MET: OK");
    }
}

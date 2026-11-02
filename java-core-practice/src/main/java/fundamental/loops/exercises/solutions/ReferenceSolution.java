package fundamental.loops.exercises.solutions;

public class ReferenceSolution {
    public static void main(String[] args) {
        int n = 5; long factorial = 1;
        for (int factor = 2; factor <= n; factor++) factorial *= factor;
        assert factorial == 120;
        n = 0; factorial = 1;
        for (int factor = 2; factor <= n; factor++) factorial *= factor;
        assert factorial == 1;
        n = 20; factorial = 1;
        for (int factor = 2; factor <= n; factor++) factorial *= factor;
        assert factorial == 2_432_902_008_176_640_000L;
        int sum = 0;
        for (int i = 1; i <= 8; i++) {
            if (i % 3 == 0) continue;
            if (i > 6) break;
            sum += i;
        }
        assert sum == 12;
        long oddSum = 0; int i = 4;
        while (i > 0) { if (i % 2 != 0) oddSum += i; i--; }
        assert oddSum == 4 && i == 0;
        i = 0; oddSum = 0;
        while (i > 0) { if (i % 2 != 0) oddSum += i; i--; }
        assert oddSum == 0;
        i = 1; oddSum = 0;
        while (i > 0) { if (i % 2 != 0) oddSum += i; i--; }
        assert oddSum == 1;
        // Loop ở ngoài chỉ là tự kiểm nhiều input, chưa sử dụng array/method.
        for (int number = 0; number <= 1; number++) {
            int copy = number, digits = 0;
            do { digits++; copy /= 10; } while (copy > 0);
            assert digits == 1;
        }
        int number = 1000, copy = number, digits = 0;
        do { digits++; copy /= 10; } while (copy > 0);
        assert digits == 4 && number == 1000;
        number = 2_147_483_647; copy = number; digits = 0;
        do { digits++; copy /= 10; } while (copy > 0);
        assert digits == 10;
        long target = 5500, total = 0; int days = 0;
        while (total < target) { days++; total += days * 1000L; }
        assert days == 3 && total == 6000;
        target = 0; total = 0; days = 0;
        while (total < target) { days++; total += days * 1000L; }
        assert days == 0 && total == 0;
        target = 1_000_000_000L; total = 0; days = 0;
        while (total < target) { days++; total += days * 1000L; }
        assert days == 1414 && total == 1_000_405_000L;
        System.out.println("LOP: OK");
    }
}

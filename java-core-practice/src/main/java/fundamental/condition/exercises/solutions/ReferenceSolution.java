package fundamental.condition.exercises.solutions;

public class ReferenceSolution {
    public static void main(String[] args) {
        // Đổi literal đầu vào để chạy lại từng ca; không cần array/method.
        int age = 6;
        String fee;
        if (age < 0 || age > 120) fee = "INVALID";
        else if (age < 6) fee = "0";
        else if (age < 18) fee = "10000";
        else fee = "20000";
        assert fee.equals("10000");
        int level = 1, legacy = 0;
        switch (level) { case 1: legacy += 10; case 2: legacy += 20; break; default: legacy = 99; }
        int modern = switch (level) { case 1 -> 10; case 2 -> 20; default -> 99; };
        assert legacy == 30 && modern == 10;
        int stock = 0;
        String action;
        if (stock < 0) action = "INVALID";
        else if (stock == 0) action = "EMPTY";
        else action = "SELL";
        assert action.equals("EMPTY");
        int a = 3, b = 4, c = 5;
        String triangle;
        if (a < 1 || b < 1 || c < 1 || a > 1_000_000 || b > 1_000_000 || c > 1_000_000
                || a + b <= c || a + c <= b || b + c <= a) triangle = "INVALID";
        else if (a == b && b == c) triangle = "EQUILATERAL";
        else if (a == b || b == c || a == c) triangle = "ISOSCELES";
        else triangle = "SCALENE";
        assert triangle.equals("SCALENE");
        int kWh = 120;
        long bill = -1;
        if (kWh < 0 || kWh > 1_000_000) System.out.println("INVALID");
        else if (kWh <= 50) bill = kWh * 1700L;
        else if (kWh <= 100) bill = 50L * 1700 + (kWh - 50) * 2000L;
        else bill = 50L * 1700 + 50L * 2000 + (kWh - 100) * 2500L;
        assert bill == 235_000;
        System.out.println("CON: OK");
    }
}

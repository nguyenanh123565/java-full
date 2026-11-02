package fundamental.condition;

public class ConditionSolution {
    public static void main(String[] args) {
        System.out.println("Bài 1: dấu của số");
        for (int number : new int[]{-3, 0, 4}) {
            if (number < 0) {
                System.out.println("Âm");
            } else if (number == 0) {
                System.out.println("Không");
            } else {
                System.out.println("Dương");
            }
        }

        System.out.println("Bài 2: xếp loại điểm");
        for (double score : new double[]{8.5, 7.0, 5.0, 4.9, -1.0, Double.NaN}) {
            System.out.println(classify(score));
        }

        System.out.println("Bài 3: năm nhuận");
        for (int year : new int[]{1900, 2000, 2024, 2023}) {
            boolean leap = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
            System.out.println(year + ": " + leap);
        }
        // Năm thế kỷ phải chia hết cho 400; 1900 không nhuận, 2000 nhuận.
    }

    private static String classify(double score) {
        if (Double.isNaN(score) || score < 0 || score > 10) {
            return "Không hợp lệ";
        }
        if (score >= 8.5) {
            return "Giỏi";
        }
        if (score >= 7) {
            return "Khá";
        }
        if (score >= 5) {
            return "Đạt";
        }
        return "Chưa đạt";
    }
}

package fundamental.variables;

public class VariableExercise {

    public static void main(String[] args) {

        // Bài 1
        int dai = 7;
        int rong = 5;

        int dientich = dai * rong;

        System.out.println(dientich);


        // Bài 2
        int total = 7;
        int people = 2;

        System.out.println(total / people);
        System.out.println((double) total / people);
        System.out.println((double) (total / people));


        // Bài 3
        int a = 50_000;
        int b = 50_000;

        int intResult = a * b;
        long wrongLongResult = a * b;
        long correctLongResult = (long) a * b;

        System.out.println(intResult);
        System.out.println(wrongLongResult);
        System.out.println(correctLongResult);


        byte f = 127;

        System.out.println("Truoc tang: " + f);

        f++;

        System.out.println("Sau tang: " + f);
    }
}
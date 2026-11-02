package exercises.easy.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static String report(int[] values){if(values.length==0)return "EMPTY";int min=values[0],max=min;long sum=0;for(int x:values){if(x<min)min=x;if(x>max)max=x;sum+=x;}return "count="+values.length+";min="+min+";max="+max+";sum="+sum;}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        int[] a={-2,4,4};check(report(a).equals("count=3;min=-2;max=4;sum=6"));check(Arrays.equals(a,new int[]{-2,4,4}));
        check(report(new int[0]).equals("EMPTY"));check(report(new int[]{Integer.MAX_VALUE,1}).endsWith("sum=2147483648"));
        check(report(new int[]{-7}).equals("count=1;min=-7;max=-7;sum=-7"));
        System.out.println("OK exercises/easy");
    }
}

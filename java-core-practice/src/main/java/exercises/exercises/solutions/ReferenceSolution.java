package exercises.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static String report(int[] values){Map<Integer,Integer>counts=new LinkedHashMap<>();long sum=0;for(int x:values){sum+=x;counts.put(x,counts.getOrDefault(x,0)+1);}return "distinct="+counts.size()+";sum="+sum+";counts="+counts;}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        int[] a={3,1,3};check(report(a).equals("distinct=2;sum=7;counts={3=2, 1=1}"));check(Arrays.equals(a,new int[]{3,1,3}));
        check(report(new int[0]).equals("distinct=0;sum=0;counts={}"));check(report(new int[]{Integer.MAX_VALUE,1}).contains("sum=2147483648"));
        System.out.println("OK exercises");
    }
}

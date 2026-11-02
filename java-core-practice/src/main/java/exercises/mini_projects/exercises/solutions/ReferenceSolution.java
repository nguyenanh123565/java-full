package exercises.mini_projects.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static String report(int[] values){Set<Integer>seen=new HashSet<>();long total=0;for(int x:values){seen.add(x);total+=x;}return "entries="+values.length+";distinct="+seen.size()+";checksum="+total;}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        int[] a={10,-2,10};check(report(a).equals("entries=3;distinct=2;checksum=18"));check(Arrays.equals(a,new int[]{10,-2,10}));
        check(report(new int[0]).equals("entries=0;distinct=0;checksum=0"));
        check(report(new int[]{Integer.MAX_VALUE,1}).endsWith("checksum=2147483648"));
        System.out.println("OK exercises/mini_projects");
    }
}

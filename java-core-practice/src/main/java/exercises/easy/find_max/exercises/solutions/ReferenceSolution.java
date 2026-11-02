package exercises.easy.find_max.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static int countAtMax(int[] a) {
        if(a.length==0) throw new IllegalArgumentException("Ngày rỗng");
        int best=a[0], count=0;
        for(int x:a) { if(x>best){best=x;count=1;} else if(x==best) count++; }
        return count;
    }
    public static int[] dailyCounts(int[][] days) {
        int[] result=new int[days.length];
        for(int i=0;i<days.length;i++) result[i]=countAtMax(days[i]);
        return result;
    }

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        int[] a={-4,-4,-9}; check(countAtMax(a)==2); check(Arrays.equals(a,new int[]{-4,-4,-9}));
        check(countAtMax(new int[]{8})==1); check(countAtMax(new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE})==1);
        check(Arrays.equals(dailyCounts(new int[][]{a,{8},{2,2,2}}),new int[]{2,1,3}));
        check(dailyCounts(new int[0][]).length==0); invalid(()->countAtMax(new int[0]));
        System.out.println("OK exercises/easy/find_max");
    }
}

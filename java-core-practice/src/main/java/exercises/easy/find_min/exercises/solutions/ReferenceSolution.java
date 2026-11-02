package exercises.easy.find_min.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static int firstMinIndex(int[] a) {
        if(a.length==0) return -1;
        int p=0; for(int i=1;i<a.length;i++) if(a[i]<a[p])p=i;
        return p;
    }
    public static String choose(String[] names,int[] prices) {
        int p=firstMinIndex(prices); return p<0?"KHONG_CO":names[p];
    }

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        check(firstMinIndex(new int[]{7,2,2,9})==1); check(firstMinIndex(new int[0])==-1);
        check(firstMinIndex(new int[]{4})==0); check(firstMinIndex(new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE})==1);
        check(choose(new String[]{"An","Binh","Chi"},new int[]{30,20,20}).equals("Binh"));
        check(choose(new String[0],new int[0]).equals("KHONG_CO"));
        System.out.println("OK exercises/easy/find_min");
    }
}

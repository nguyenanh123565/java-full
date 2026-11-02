package exercises.easy.count_frequency.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static int[] singletons(int[] a) {
        Map<Integer,Integer> m=new HashMap<>(); for(int x:a)m.put(x,m.getOrDefault(x,0)+1);
        int size=0; for(int x:a)if(m.get(x)==1)size++;
        int[] out=new int[size]; int i=0;for(int x:a)if(m.get(x)==1)out[i++]=x;return out;
    }
    public static long uniqueSum(int[] a){long sum=0;for(int x:singletons(a))sum+=x;return sum;}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        int[] a={4,2,4,9,2,7};check(Arrays.equals(singletons(a),new int[]{9,7}));
        check(Arrays.equals(a,new int[]{4,2,4,9,2,7}));check(singletons(new int[0]).length==0);
        check(singletons(new int[]{3,3}).length==0);check(uniqueSum(a)==16);
        check(uniqueSum(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE-1})==4294967293L);
        check(uniqueSum(new int[0])==0);
        System.out.println("OK exercises/easy/count_frequency");
    }
}

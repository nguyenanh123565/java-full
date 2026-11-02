package exercises.easy.two_sum.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static long pairCount(int[] a,int target){
        Map<Long,Long> seen=new HashMap<>();long out=0;
        for(int x:a){out+=seen.getOrDefault((long)target-x,0L);long key=x;seen.put(key,seen.getOrDefault(key,0L)+1);}
        return out;
    }
    public static long[] counts(int[] a,int[] targets){long[] out=new long[targets.length];for(int i=0;i<out.length;i++)out[i]=pairCount(a,targets[i]);return out;}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        check(pairCount(new int[]{4,4,4},8)==3);check(pairCount(new int[]{1,3,2,2},4)==2);
        check(pairCount(new int[]{4},8)==0);check(pairCount(new int[0],0)==0);
        check(pairCount(new int[]{Integer.MAX_VALUE,1},Integer.MIN_VALUE)==0);
        check(Arrays.equals(counts(new int[]{1,3,2,2},new int[]{4,5,99}),new long[]{2,2,0}));
        int[] many=new int[65537];check(pairCount(many,0)==2147516416L);
        System.out.println("OK exercises/easy/two_sum");
    }
}

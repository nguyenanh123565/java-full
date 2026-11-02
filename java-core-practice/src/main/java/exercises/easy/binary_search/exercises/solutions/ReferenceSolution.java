package exercises.easy.binary_search.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static int firstIndex(int[] a,int target){int l=0,r=a.length-1,out=-1;while(l<=r){int m=l+(r-l)/2;if(a[m]>=target){if(a[m]==target)out=m;r=m-1;}else l=m+1;}return out;}
    public static int[] lookup(int[] sorted,int[] targets){int[] out=new int[targets.length];for(int i=0;i<out.length;i++)out[i]=firstIndex(sorted,targets[i]);return out;}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        check(firstIndex(new int[]{1,2,2,2,8},2)==1);check(firstIndex(new int[]{2,2,2},2)==0);
        check(firstIndex(new int[0],2)==-1);check(firstIndex(new int[]{4},4)==0);check(firstIndex(new int[]{4},5)==-1);
        check(Arrays.equals(lookup(new int[]{1,2,2,8},new int[]{2,7,1}),new int[]{1,-1,0}));
        check(firstIndex(new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE},Integer.MAX_VALUE)==1);
        System.out.println("OK exercises/easy/binary_search");
    }
}

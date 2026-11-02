package exercises.easy.reverse_array.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static void reverseRange(int[] a,int from,int to) {
        if(from<0||from>to||to>a.length) throw new IllegalArgumentException("Đoạn sai");
        for(int l=from,r=to-1;l<r;l++,r--){int t=a[l];a[l]=a[r];a[r]=t;}
    }
    public static void rotateLeft(int[] a,int k) {
        if(k<0||k>a.length) throw new IllegalArgumentException("k sai");
        reverseRange(a,0,k); reverseRange(a,k,a.length); reverseRange(a,0,a.length);
    }

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        int[] a={1,2,3,4,5}; reverseRange(a,1,4); check(Arrays.equals(a,new int[]{1,4,3,2,5}));
        int[] b={1,2,3,4,5}; rotateLeft(b,2); check(Arrays.equals(b,new int[]{3,4,5,1,2}));
        int[] old=b.clone(); invalid(()->reverseRange(b,3,2)); check(Arrays.equals(b,old));
        invalid(()->reverseRange(b,-1,2)); invalid(()->reverseRange(b,0,6)); invalid(()->rotateLeft(b,-1));
        rotateLeft(new int[0],0); rotateLeft(b,b.length); check(Arrays.equals(b,old));
        System.out.println("OK exercises/easy/reverse_array");
    }
}

package exercises.medium.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static int[] groupSizes(String[] words){
        Map<String,Integer> groups=new LinkedHashMap<>();
        for(String word:words){String normalized=word.trim().toLowerCase(Locale.ROOT);int[] counts=new int[26];
            for(char c:normalized.toCharArray()){if(c<'a'||c>'z')throw new IllegalArgumentException("Chỉ nhận a-z");counts[c-'a']++;}
            String key=Arrays.toString(counts);groups.put(key,groups.getOrDefault(key,0)+1);
        }
        int[] out=new int[groups.size()];int p=0;for(int size:groups.values())out[p++]=size;return out;
    }
    public static long[] bestWindow(int[] a,int k){
        if(k<=0||k>a.length)throw new IllegalArgumentException("k sai");
        long sum=0;for(int i=0;i<k;i++)sum+=a[i];long best=sum;int start=0;
        for(int i=k;i<a.length;i++){sum+=(long)a[i]-a[i-k];if(sum>best){best=sum;start=i-k+1;}}
        return new long[]{start,best};
    }
    public static String report(String[] words,int[] a,int k){return "groups="+Arrays.toString(groupSizes(words))+";window="+Arrays.toString(bestWindow(a,k));}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        String[] words={"eat","Tea","ate","tan","Nat"};int[] a={-2,4,-1,3};
        check(Arrays.equals(groupSizes(words),new int[]{3,2}));check(Arrays.equals(groupSizes(new String[]{""," "}),new int[]{2}));
        check(groupSizes(new String[0]).length==0);invalid(()->groupSizes(new String[]{"a1"}));
        check(Arrays.equals(bestWindow(a,2),new long[]{1,3}));check(Arrays.equals(bestWindow(new int[]{1,1,1},2),new long[]{0,2}));
        check(Arrays.equals(bestWindow(new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE},2),new long[]{0,4294967294L}));
        check(Arrays.equals(bestWindow(new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE},1),new long[]{1,Integer.MAX_VALUE}));
        check(Arrays.equals(bestWindow(new int[]{-3,-1,-2},2),new long[]{1,-3}));
        invalid(()->bestWindow(new int[0],1));invalid(()->bestWindow(a,0));invalid(()->bestWindow(a,5));
        check(report(words,a,2).equals("groups=[3, 2];window=[1, 3]"));check(Arrays.equals(a,new int[]{-2,4,-1,3}));
        System.out.println("OK exercises/medium");
    }
}

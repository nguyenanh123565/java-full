package exercises.easy.remove_duplicate.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static int[] repeated(int[] a) {
        Map<Integer,Integer> m=new LinkedHashMap<>();for(int x:a)m.put(x,m.getOrDefault(x,0)+1);
        int n=0;for(int c:m.values())if(c>=2)n++;
        int[] out=new int[n];int i=0;for(Map.Entry<Integer,Integer> e:m.entrySet())if(e.getValue()>=2)out[i++]=e.getKey();return out;
    }
    public static String report(int[] ids){Set<Integer>s=new HashSet<>();for(int x:ids)s.add(x);return "distinct="+s.size()+";repeated="+repeated(ids).length;}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        check(Arrays.equals(repeated(new int[]{5,2,2,5,7}),new int[]{5,2}));
        check(Arrays.equals(repeated(new int[]{3,3,3}),new int[]{3}));check(repeated(new int[0]).length==0);
        check(repeated(new int[]{1,2}).length==0);check(report(new int[]{5,2,2,5,7}).equals("distinct=3;repeated=2"));
        check(report(new int[0]).equals("distinct=0;repeated=0"));
        System.out.println("OK exercises/easy/remove_duplicate");
    }
}

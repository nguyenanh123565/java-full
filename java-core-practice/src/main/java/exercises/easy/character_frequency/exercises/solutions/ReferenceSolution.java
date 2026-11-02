package exercises.easy.character_frequency.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static Character mostFrequent(String s){Map<Character,Integer> m=new LinkedHashMap<>();for(char c:s.toCharArray())m.put(c,m.getOrDefault(c,0)+1);Character best=null;int n=0;for(Map.Entry<Character,Integer>e:m.entrySet())if(e.getValue()>n){best=e.getKey();n=e.getValue();}return best;}
    public static Character[] summaries(String[] texts){Character[] out=new Character[texts.length];for(int i=0;i<out.length;i++)out[i]=mostFrequent(texts[i]);return out;}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        check(mostFrequent("baba ")=='b');check(mostFrequent("Aa")=='A');check(mostFrequent("")==null);
        check(mostFrequent("  a")==' ');check(Arrays.equals(summaries(new String[]{"baba ","Aa","","  a"}),new Character[]{'b','A',null,' '}));
        check(summaries(new String[0]).length==0);
        System.out.println("OK exercises/easy/character_frequency");
    }
}

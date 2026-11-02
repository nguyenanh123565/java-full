package exercises.easy.valid_parentheses.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static int maxDepth(String text){Deque<Character>s=new ArrayDeque<>();int best=0;for(char c:text.toCharArray()){if(c=='('||c=='['||c=='{'){s.push(c);best=Math.max(best,s.size());}else{char expected;switch(c){case ')'->expected='(';case ']'->expected='[';case '}'->expected='{';default->{return -1;}}if(s.isEmpty()||s.pop()!=expected)return -1;}}return s.isEmpty()?best:-1;}
    public static int[] depths(String[] texts){int[] out=new int[texts.length];for(int i=0;i<out.length;i++)out[i]=maxDepth(texts[i]);return out;}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        check(maxDepth("{[()]}")==3);check(maxDepth("()[]")==1);check(maxDepth("")==0);
        check(maxDepth("([)]")==-1);check(maxDepth("]")==-1);check(maxDepth("(")==-1);check(maxDepth(" ")==-1);
        check(Arrays.equals(depths(new String[]{"{[()]}","([)]","","]"}),new int[]{3,-1,0,-1}));
        System.out.println("OK exercises/easy/valid_parentheses");
    }
}

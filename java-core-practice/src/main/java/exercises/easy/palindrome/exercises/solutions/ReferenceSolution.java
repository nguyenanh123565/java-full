package exercises.easy.palindrome.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    public static boolean ignoringSpaces(String s){int l=0,r=s.length()-1;while(l<r){while(l<r&&s.charAt(l)==' ')l++;while(l<r&&s.charAt(r)==' ')r--;if(s.charAt(l)!=s.charAt(r))return false;l++;r--;}return true;}
    public static int accepted(String[] labels){int n=0;for(String s:labels)if(ignoringSpaces(s))n++;return n;}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        check(ignoringSpaces("a b a"));check(!ignoringSpaces("Aa"));check(ignoringSpaces("   "));
        check(ignoringSpaces(""));check(!ignoringSpaces("a	b"));check(!ignoringSpaces("abca"));
        check(accepted(new String[]{"a b a","Aa","   ","abc"})==2);check(accepted(new String[0])==0);
        System.out.println("OK exercises/easy/palindrome");
    }
}

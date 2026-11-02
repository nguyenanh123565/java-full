package fundamental.strings.exercises.solutions;

import java.util.Locale;
public class ReferenceSolution {
    public static int countVowels(String text) {
        String upper=text.toUpperCase(Locale.ROOT); int count=0;
        for(int i=0;i<upper.length();i++) { char c=upper.charAt(i); if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U')count++; }
        return count;
    }
    public static boolean isExit(String text) { return text!=null && "EXIT".equals(text.trim().toUpperCase(Locale.ROOT)); }
    public static String joinLabels(String[] labels) {
        StringBuilder out=new StringBuilder();
        for(String label:labels) {
            if(label==null)continue;
            String clean=label.trim(); if(clean.length()==0)continue;
            if(out.length()>0)out.append('|'); out.append(clean);
        }
        return out.toString();
    }
    public static boolean validCode(String code) {
        if(code==null)return false;
        String clean=code.trim().toUpperCase(Locale.ROOT); if(clean.length()!=3)return false;
        for(int i=0;i<clean.length();i++)if(clean.charAt(i)<'A'||clean.charAt(i)>'Z')return false;
        return true;
    }
    public static String codeReport(String[] codes) {
        StringBuilder out=new StringBuilder();
        for(String code:codes) if(validCode(code)) {
            if(out.length()>0)out.append('|'); out.append(code.trim().toUpperCase(Locale.ROOT));
        }
        return out.toString();
    }
    public static void main(String[] args) {
        assert countVowels("Java CORE")==4 && countVowels("rhythm")==0 && countVowels("AEIOU")==5;
        assert countVowels("")==0 && countVowels(" ")==0 && countVowels("aaa")==3;
        StringBuilder a=new StringBuilder("A"),b=a; String saved=a.toString();
        b.append("B"); b=new StringBuilder("C"); b.append("D");
        assert a.toString().equals("AB") && b.toString().equals("CD") && saved.equals("A") && a!=b;
        assert isExit(new String(" EXIT ")) && isExit("exit") && !isExit(null) && !isExit("EX IT");
        assert !isExit("") && !isExit("   ");
        String[] labels={" A ",null," ","B"};
        assert joinLabels(labels).equals("A|B") && labels[0].equals(" A ");
        assert joinLabels(new String[0]).equals("") && joinLabels(new String[]{null," "}).equals("");
        assert joinLabels(new String[]{"A","A"}).equals("A|A");
        String[] codes={" abC ","b-2",null," xyz ","   ","JAVA","ABC"};
        assert codeReport(codes).equals("ABC|XYZ|ABC") && codes[0].equals(" abC ");
        assert !validCode("ab") && !validCode("ABCD") && !validCode("A B") && !validCode("12A");
        assert codeReport(new String[0]).equals("") && codeReport(new String[]{null,"-"}).equals("");
        System.out.println("STR: OK");
    }
}

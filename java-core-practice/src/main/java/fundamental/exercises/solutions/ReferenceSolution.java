package fundamental.exercises.solutions;

import java.util.Arrays;
import java.util.Locale;
public class ReferenceSolution {
    public static int readCount(String text){
        if(text==null||text.length()==0||text.length()>6)return -1;
        int value=0;for(int i=0;i<text.length();i++){
            char c=text.charAt(i);if(c<'0'||c>'9')return -1;value=value*10+c-'0';
        }return value;
    }
    public static void inspect(String name,int[] values){name=name+"!";values[0]++;values=new int[]{99};}
    public static double average(int[] values){long sum=0;for(int value:values)sum+=value;return (double)sum/values.length;}
    public static String gradeReport(int[] scores){
        int valid=0,pass=0,invalid=0;long sum=0;
        for(int score:scores){if(score<0||score>100){invalid++;continue;}valid++;sum+=score;if(score>=50)pass++;}
        return "valid="+valid+";pass="+pass+";invalid="+invalid+";sum="+sum;
    }
    public static boolean validName(String name){
        if(name==null)return false;String clean=name.trim();
        if(clean.length()==0)return false;
        for(int i=0;i<clean.length();i++){char c=clean.charAt(i);if(c!=' '&&(c<'A'||c>'Z')&&(c<'a'||c>'z'))return false;}return true;
    }
    public static String receipt(String[] names,int[] quantities,int[] prices){
        if(names==null||quantities==null||prices==null||names.length!=quantities.length||names.length!=prices.length||names.length>1000)return "INVALID";
        if(names.length==0)return "EMPTY";
        for(int i=0;i<names.length;i++)if(!validName(names[i])||quantities[i]<0||quantities[i]>1000||prices[i]<0||prices[i]>1_000_000)return "INVALID";
        StringBuilder out=new StringBuilder();long total=0;
        for(int i=0;i<names.length;i++){
            long line=1L*quantities[i]*prices[i];total+=line;if(i>0)out.append('|');
            out.append(names[i].trim().toUpperCase(Locale.ROOT)).append('=').append(line);
        }return out.append(";TOTAL=").append(total).toString();
    }
    public static void main(String[] args){
        assert readCount("0042")==42&&readCount("0")==0&&readCount("999999")==999999;
        assert readCount("12a")==-1&&readCount(null)==-1&&readCount("")==-1&&readCount("1234567")==-1;
        assert readCount(" 12")==-1&&readCount("-1")==-1;
        String name="A";int[] data={1},copy=Arrays.copyOf(data,1);inspect(name,data);
        assert name.equals("A")&&data[0]==2&&copy[0]==1;
        assert average(new int[]{2_000_000_000,2_000_000_000})==2_000_000_000.0;
        assert average(new int[]{1,2})==1.5&&average(new int[]{0})==0.0;
        assert gradeReport(new int[]{100,-1,50,49,101}).equals("valid=3;pass=2;invalid=2;sum=199");
        assert gradeReport(new int[0]).equals("valid=0;pass=0;invalid=0;sum=0");
        assert gradeReport(new int[]{-1,101}).equals("valid=0;pass=0;invalid=2;sum=0");
        String[] names={" pen ","book"};int[] quantities={3,2},prices={2000,10000};
        assert receipt(names,quantities,prices).equals("PEN=6000|BOOK=20000;TOTAL=26000");
        assert names[0].equals(" pen ")&&quantities[0]==3&&prices[0]==2000;
        assert receipt(new String[0],new int[0],new int[0]).equals("EMPTY");
        assert receipt(null,quantities,prices).equals("INVALID");
        assert receipt(names,new int[1],prices).equals("INVALID");
        assert receipt(new String[]{null},new int[]{1},new int[]{1}).equals("INVALID");
        assert receipt(new String[]{" "},new int[]{1},new int[]{1}).equals("INVALID");
        assert receipt(new String[]{"ß"},new int[]{1},new int[]{1}).equals("INVALID");
        assert receipt(new String[]{"A"},new int[]{-1},new int[]{1}).equals("INVALID");
        assert receipt(new String[]{"A"},new int[]{0},new int[]{1}).equals("A=0;TOTAL=0");
        String[] many=new String[1000];int[] qs=new int[1000],ps=new int[1000];
        Arrays.fill(many,"A");Arrays.fill(qs,1000);Arrays.fill(ps,1_000_000);
        String big=receipt(many,qs,ps);assert big.substring(big.length()-20).equals(";TOTAL=1000000000000");
        System.out.println("FUN: OK");
    }
}

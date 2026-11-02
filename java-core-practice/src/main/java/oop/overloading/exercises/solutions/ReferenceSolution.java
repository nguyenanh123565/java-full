package oop.overloading.exercises.solutions;
class Labeler {
    String label(String text){return label(text,1);}
    String label(String text,int copies){
        if(copies<0||copies>5)return "INVALID";if(text==null)text="";
        String out="";for(int i=0;i<copies;i++){if(i>0)out+="|";out+=text;}return out;
    }
    String tag(int count){return label("X",count);} String tag(String text,int count){return label(text,count);}
    int size(String s){return s==null?0:s.length();}
}
class Chooser {String pick(int v){return "int";}String pick(long v){return "long";}}
class PairFormatter {
    String format(String text,int count){return (text==null?"":text)+":"+count;}
    String format(int count,String text){return count+":"+(text==null?"":text);}
}
class Formatter {String format(Object o){return "base-object";}String format(String s){return "base-string";}}
class FancyFormatter extends Formatter {@Override String format(Object o){return "fancy-object";}}
public class ReferenceSolution {
    static void check(boolean ok,String id){if(!ok)throw new AssertionError(id);}
    public static void main(String[] args){
        Labeler l=new Labeler();check(l.label("A").equals("A")&&l.label("A",3).equals("A|A|A")&&l.label("A",0).equals(""),"OVL-01");
        check(l.label(null,2).equals("|")&&l.label("A",-1).equals("INVALID")&&l.label("A",6).equals("INVALID")&&l.label("A",5).equals("A|A|A|A|A"),"OVL-01 bounds");
        Chooser c=new Chooser();short n=3;check(c.pick(3).equals("int")&&c.pick(3L).equals("long")&&c.pick(n).equals("int")&&c.pick(2147483648L).equals("long"),"OVL-02");
        check(l.tag(2).equals("X|X")&&l.tag("A",2).equals("A|A")&&l.size("AB")==2&&l.size(null)==0,"OVL-03");
        PairFormatter p=new PairFormatter();check(p.format("A",2).equals("A:2")&&p.format(2,"A").equals("2:A")&&p.format(null,-1).equals(":-1")&&p.format(0,null).equals("0:"),"OVL-04");
        Formatter f=new FancyFormatter();String s="A";Object o=s;
        check(f.format(s).equals("base-string")&&f.format(o).equals("fancy-object")&&f.format(null).equals("base-string"),"OVL-05");
        System.out.println("PASS OVL-01..05");
    }
}

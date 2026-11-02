package oop.interface_demo.exercises.solutions;
interface TextFormatter { String format(String text); }
class BracketFormatter implements TextFormatter { @Override public String format(String t){return "["+(t==null?"":t)+"]";} }
class HashFormatter implements TextFormatter { @Override public String format(String t){return "#"+(t==null?"":t)+"#";} }
interface Switchable { boolean turnOn(); }
interface Readable { boolean isOn(); }
class Lamp implements Switchable,Readable {
    private boolean on;
    @Override public boolean turnOn(){on=true;return true;}
    @Override public boolean isOn(){return on;}
}
interface Rule { boolean accepts(String text); }
class NonEmptyRule implements Rule { @Override public boolean accepts(String t){return t!=null&&!t.isEmpty();} }
class MaxLengthRule implements Rule {
    private int max;
    MaxLengthRule(int max){this.max=max>=0&&max<=20?max:0;}
    @Override public boolean accepts(String t){return t!=null&&t.length()<=max;}
}
class StartsWithARule implements Rule { @Override public boolean accepts(String t){return t!=null&&!t.isEmpty()&&t.charAt(0)=='A';} }
public class ReferenceSolution {
    static void check(boolean ok,String id){if(!ok)throw new AssertionError(id);}
    static String[] formatAll(TextFormatter[] fs,String text){
        if(fs==null)return new String[0]; String[] out=new String[fs.length];
        for(int i=0;i<fs.length;i++)out[i]=fs[i]==null?"SKIP":fs[i].format(text);return out;
    }
    static boolean acceptsAll(Rule[] rules,String text){if(rules==null)return false;for(Rule r:rules)if(r==null||!r.accepts(text))return false;return true;}
    public static void main(String[] args){
        TextFormatter f=new BracketFormatter();check(f.format("Java").equals("[Java]")&&f.format(null).equals("[]")&&f.format("").equals("[]"),"INT-01");
        Lamp lamp=new Lamp();Switchable s=lamp;Readable r=lamp;check(!r.isOn()&&s.turnOn()&&r.isOn()&&s.turnOn(),"INT-02");
        check(f.format("A").equals("[A]")&&f.format(null).equals("[]"),"INT-03");
        String[] out=formatAll(new TextFormatter[]{f,new HashFormatter(),null},"A");
        check(out[0].equals("[A]")&&out[1].equals("#A#")&&out[2].equals("SKIP")&&formatAll(null,"").length==0&&formatAll(new TextFormatter[0],"").length==0,"INT-04");
        check(new HashFormatter().format(null).equals("##"),"INT-04 null");
        Rule[] rules={new NonEmptyRule(),new MaxLengthRule(3)};
        check(acceptsAll(rules,"An")&&!acceptsAll(rules,"")&&!acceptsAll(rules,"Long")&&!acceptsAll(rules,null),"INT-05");
        Rule[] extended={rules[0],rules[1],new StartsWithARule()};
        check(acceptsAll(extended,"An")&&!acceptsAll(extended,"Bo")&&!acceptsAll(null,"An")&&!acceptsAll(new Rule[]{null},"An")&&acceptsAll(new Rule[0],null),"INT-05 composition");
        check(new MaxLengthRule(-1).accepts("")&&!new MaxLengthRule(0).accepts("a")&&new MaxLengthRule(20).accepts("12345678901234567890"),"INT-05 bounds");
        System.out.println("PASS INT-01..05");
    }
}

package oop.composition.exercises.solutions;
class Ink {
    private int units=10;
    int remaining(){return units;}
    boolean consume(int n){if(n<=0||n>units)return false;units-=n;return true;}
}
class Printer {
    private Ink ink=new Ink();
    boolean print(int pages){return ink.consume(pages);}
    int remaining(){return ink.remaining();}
}
class SharedPrinter {
    private Ink ink;
    SharedPrinter(Ink ink){this.ink=ink==null?new Ink():ink;}
    boolean print(int n){return ink.consume(n);} int remaining(){return ink.remaining();}
}
interface PriceRule {int finalPrice(int price);}
class IdentityRule implements PriceRule {@Override public int finalPrice(int p){return p<0||p>10000?-1:p;}}
class HalfRule implements PriceRule {@Override public int finalPrice(int p){return p<0||p>10000?-1:p/2;}}
class Checkout {
    private PriceRule rule; Checkout(PriceRule rule){this.rule=rule==null?new IdentityRule():rule;}
    int quote(int price){return rule.finalPrice(price);}
}
class Task {
    private String title;
    Task(String title){this.title=title==null||title.isEmpty()?"Untitled":title;}
    String getTitle(){return title;}
    boolean rename(String title){if(title==null||title.isEmpty())return false;this.title=title;return true;}
}
class Board {
    private Task[] tasks;
    Board(Task[] tasks){this.tasks=copy(tasks);}
    private Task[] copy(Task[] source){if(source==null)return new Task[0];Task[] out=new Task[source.length];for(int i=0;i<out.length;i++)out[i]=source[i];return out;}
    Task[] getTasks(){return copy(tasks);}
}
interface ReceiptStyle {String format(int pages,int remaining);}
class PlainStyle implements ReceiptStyle {@Override public String format(int p,int r){return p+":"+r;}}
class FancyStyle implements ReceiptStyle {@Override public String format(int p,int r){return "["+p+":"+r+"]";}}
class PrintDesk {
    private Printer printer; private ReceiptStyle style;
    PrintDesk(Printer printer,ReceiptStyle style){this.printer=printer==null?new Printer():printer;this.style=style==null?new PlainStyle():style;}
    String submit(int pages){if(!printer.print(pages))return "REJECTED";return style.format(pages,printer.remaining());}
}
public class ReferenceSolution {
    static void check(boolean ok,String id){if(!ok)throw new AssertionError(id);}
    public static void main(String[] args){
        Printer p=new Printer();check(p.print(3)&&p.remaining()==7&&!p.print(8)&&p.remaining()==7&&!p.print(0)&&!p.print(-1),"COMP-01");
        Printer exact=new Printer();check(exact.print(10)&&exact.remaining()==0&&!exact.print(1),"COMP-01 empty");
        Ink shared=new Ink();SharedPrinter a=new SharedPrinter(shared),b=new SharedPrinter(shared);a.print(3);b.print(2);check(a.remaining()==5&&b.remaining()==5,"COMP-02");
        Printer x=new Printer(),y=new Printer();x.print(3);y.print(2);check(x.remaining()==7&&y.remaining()==8,"COMP-02 separate");
        SharedPrinter fallbackA=new SharedPrinter(null),fallbackB=new SharedPrinter(null);fallbackA.print(1);check(fallbackB.remaining()==10,"COMP-02 null");
        check(new Checkout(new HalfRule()).quote(101)==50&&new Checkout(null).quote(101)==101&&new Checkout(new HalfRule()).quote(-1)==-1&&new Checkout(null).quote(10001)==-1,"COMP-03");
        Task original=new Task("A");Task[] input={original};Board board=new Board(input);input[0]=new Task("B");check(board.getTasks()[0].getTitle().equals("A"),"COMP-04 input copy");
        Task[] output=board.getTasks();output[0]=null;check(board.getTasks()[0]==original,"COMP-04 output copy");
        check(board.getTasks()[0].rename("C")&&board.getTasks()[0].getTitle().equals("C")&&!original.rename(null)&&!original.rename("")&&original.getTitle().equals("C"),"COMP-04 element shared");
        check(new Board(null).getTasks().length==0&&new Board(new Task[0]).getTasks().length==0&&new Board(new Task[]{null}).getTasks()[0]==null,"COMP-04 edge");
        PrintDesk desk=new PrintDesk(null,null);check(desk.submit(3).equals("3:7")&&desk.submit(8).equals("REJECTED")&&desk.submit(0).equals("REJECTED")&&desk.submit(7).equals("7:0"),"COMP-05");
        check(new PrintDesk(null,new FancyStyle()).submit(2).equals("[2:8]"),"COMP-05 style");
        Printer common=new Printer();PrintDesk d1=new PrintDesk(common,null),d2=new PrintDesk(common,null);check(d1.submit(3).equals("3:7")&&d2.submit(2).equals("2:5"),"COMP-05 shared");
        System.out.println("PASS COMP-01..05");
    }
}

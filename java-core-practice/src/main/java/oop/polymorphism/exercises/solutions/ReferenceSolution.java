package oop.polymorphism.exercises.solutions;
abstract class Discount {
    boolean valid(int price){return price>=0 && price<=10000;}
    abstract int apply(int price);
}
class NoDiscount extends Discount { @Override int apply(int p){return valid(p)?p:-1;} }
class HalfDiscount extends Discount { @Override int apply(int p){return valid(p)?p/2:-1;} }
class MinusTenDiscount extends Discount { @Override int apply(int p){return !valid(p)?-1:p<10?0:p-10;} }
public class ReferenceSolution {
    static void check(boolean ok,String id){if(!ok)throw new AssertionError(id);}
    static int[] quote(Discount[] discounts,int price){
        if(discounts==null)return new int[0];
        int[] result=new int[discounts.length];
        for(int i=0;i<result.length;i++)result[i]=discounts[i]==null?-1:discounts[i].apply(price);
        return result;
    }
    public static void main(String[] args){
        Discount none=new NoDiscount(),half=new HalfDiscount();
        check(none.apply(101)==101 && half.apply(101)==50 && half.apply(0)==0 && half.apply(1)==0 && half.apply(10000)==5000 && half.apply(-1)==-1 && half.apply(10001)==-1,"POLY-01");
        Discount a=new HalfDiscount(); Discount b=a; check(a==b,"POLY-02 initial"); a=new NoDiscount();
        check(a.apply(100)==100 && b.apply(100)==50 && a!=b,"POLY-02");
        Discount fixed=new HalfDiscount(); check(fixed.apply(100)==50 && fixed.apply(101)==50 && fixed.apply(-1)==-1,"POLY-03");
        Discount[] options={none,half,null}; int[] out=quote(options,101);
        check(out.length==3 && out[0]==101 && out[1]==50 && out[2]==-1 && options[0]==none,"POLY-04");
        check(quote(null,0).length==0 && quote(new Discount[0],0).length==0 && quote(options,-1)[0]==-1,"POLY-04 edge");
        Discount minus=new MinusTenDiscount(); int[] last=quote(new Discount[]{none,half,minus},9);
        check(last[0]==9 && last[1]==4 && last[2]==0 && minus.apply(101)==91,"POLY-05");
        check(minus.apply(0)==0 && minus.apply(10)==0 && minus.apply(10000)==9990 && minus.apply(-1)==-1 && minus.apply(10001)==-1,"POLY-05 edge");
        System.out.println("PASS POLY-01..05");
    }
}

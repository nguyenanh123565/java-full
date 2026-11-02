package oop.abstraction.exercises.solutions;
abstract class Delivery {
    String label() { return "Delivery"; }
    abstract int base(); abstract int rate();
    int fee(int km) { return km < 0 || km > 100 ? -1 : base() + km * rate(); }
}
class FlatDelivery extends Delivery { @Override int base(){return 20;} @Override int rate(){return 0;} }
class BikeDelivery extends Delivery { @Override int base(){return 10;} @Override int rate(){return 2;} }
class VanDelivery extends Delivery { @Override int base(){return 20;} @Override int rate(){return 3;} }
// ABS-02 la mot doan suy luan doc lap: base=10 cho ca hai loai.
abstract class ReasoningDelivery {abstract int rate();int fee(int km){return 10+km*rate();}}
class ReasoningBike extends ReasoningDelivery {@Override int rate(){return 2;}}
class ReasoningVan extends ReasoningDelivery {@Override int rate(){return 4;}}
// ABS-03: ban sua truc tiep cua chu ky sai fee().
abstract class DebugDelivery {abstract int fee(int km);}
class FixedBikeDelivery extends DebugDelivery {@Override int fee(int km){return km<0||km>100?-1:10+2*km;}}
abstract class Label {
    private String prefix;
    Label(String prefix){ this.prefix = prefix == null || prefix.isEmpty() ? "INFO" : prefix; }
    abstract String content();
    String render(){return prefix + ":" + content();}
}
class StockLabel extends Label {
    private int quantity;
    StockLabel(String prefix,int quantity){ super(prefix); this.quantity = quantity < 0 ? 0 : quantity; }
    @Override String content(){return "stock=" + quantity;}
}
public class ReferenceSolution {
    static void check(boolean ok,String id){if(!ok)throw new AssertionError(id);}
    static int cheapest(Delivery[] options,int km){
        int best=-1;
        if(options != null)for(Delivery d:options)if(d != null){int fee=d.fee(km);if(fee>=0 && (best<0||fee<best))best=fee;}
        return best;
    }
    public static void main(String[] args){
        Delivery flat = new FlatDelivery(); check(flat.label().equals("Delivery") && flat.fee(0)==20 && flat.fee(100)==20 && flat.fee(-1)==-1 && flat.fee(101)==-1,"ABS-01");
        Delivery bike = new BikeDelivery(), van = new VanDelivery();
        check(new ReasoningBike().fee(5)==20 && new ReasoningBike().fee(0)==10 && new ReasoningVan().fee(5)==30,"ABS-02");
        DebugDelivery fixed=new FixedBikeDelivery();
        check(fixed.fee(5)==20 && fixed.fee(-1)==-1 && fixed.fee(101)==-1,"ABS-03");
        check(new StockLabel("SHOP",3).render().equals("SHOP:stock=3") && new StockLabel(null,-1).render().equals("INFO:stock=0") && new StockLabel("",0).render().equals("INFO:stock=0"),"ABS-04");
        check(cheapest(new Delivery[]{bike,null,van},5)==20 && cheapest(new Delivery[]{van},5)==35,"ABS-05 normal");
        check(cheapest(null,0)==-1 && cheapest(new Delivery[0],0)==-1 && cheapest(new Delivery[]{null},0)==-1 && cheapest(new Delivery[]{bike,van},-1)==-1 && cheapest(new Delivery[]{bike,van},101)==-1 && cheapest(new Delivery[]{bike,van},0)==10,"ABS-05 edge");
        System.out.println("PASS ABS-01..05");
    }
}

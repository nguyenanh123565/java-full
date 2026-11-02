package exercises.mini_projects.product_management.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    private static void text(String s){if(s==null||s.isBlank())throw new IllegalArgumentException("Chuỗi rỗng");}
    public static long value(long price,int stock){if(price<0||stock<0)throw new IllegalArgumentException("Âm");return Math.multiplyExact(price,(long)stock);}
    private static class Product {
        private final String id,name;
        private final long price;
        private int stock;
        Product(String id,String name,long price,int stock){text(id);text(name);if(price<0||stock<0)throw new IllegalArgumentException("Âm");this.id=id;this.name=name.trim();this.price=price;this.stock=stock;}
    }
    public static class Snapshot {
        public final String id,name;
        public final long price;
        public final int stock;
        Snapshot(Product p){id=p.id;name=p.name;price=p.price;stock=p.stock;}
        public String toString(){return id+":"+price+":"+stock;}
    }
    public static class Service {
        private final Map<String,Product> products=new LinkedHashMap<>();
        public void add(String id,String name,long price,int stock){Product p=new Product(id,name,price,stock);if(products.containsKey(id))throw new IllegalArgumentException("Trùng mã");products.put(id,p);}
        public int stock(String id){Product p=products.get(id);if(p==null)throw new IllegalArgumentException("Không có mã");return p.stock;}
        public long sell(String[] ids,int[] quantities){
            if(ids.length!=quantities.length)throw new IllegalArgumentException("Khác độ dài");
            Map<String,Integer> totals=new LinkedHashMap<>();
            for(int i=0;i<ids.length;i++){text(ids[i]);if(quantities[i]<=0)throw new IllegalArgumentException("Lượng sai");totals.put(ids[i],Math.addExact(totals.getOrDefault(ids[i],0),quantities[i]));}
            long bill=0;
            for(Map.Entry<String,Integer> e:totals.entrySet()){Product p=products.get(e.getKey());if(p==null||p.stock<e.getValue())throw new IllegalArgumentException("Không đủ hàng");bill=Math.addExact(bill,Math.multiplyExact(p.price,(long)e.getValue()));}
            for(Map.Entry<String,Integer> e:totals.entrySet())products.get(e.getKey()).stock-=e.getValue();
            return bill;
        }
        public List<Snapshot> snapshot(){
            List<Snapshot> out=new ArrayList<>();
            for(Product p:products.values())out.add(new Snapshot(p));
            out.sort(new Comparator<Snapshot>() {
                @Override public int compare(Snapshot left,Snapshot right) {
                    int byPrice=Long.compare(right.price,left.price);
                    return byPrice!=0?byPrice:left.id.compareTo(right.id);
                }
            });
            return out;
        }
        public String command(String line){try{String[] p=line.split(";",-1);if(p.length==1&&p[0].equals("EXIT"))return "BYE";if(p.length==1&&p[0].equals("LIST"))return snapshot().toString();if(p.length==3&&p[0].equals("SELL"))return Long.toString(sell(new String[]{p[1]},new int[]{Integer.parseInt(p[2])}));return "ERR";}catch(IllegalArgumentException|ArithmeticException ex){return "ERR";}}
    }
    public static void console(Service service,Scanner input){while(input.hasNextLine()){String result=service.command(input.nextLine());System.out.println(result);if(result.equals("BYE"))break;}}
    private static void overflow(Runnable action){try{action.run();}catch(ArithmeticException expected){return;}throw new AssertionError("Phải phát hiện overflow");}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        check(value(12000,3)==36000);check(value(12000,1)==12000);overflow(()->value(Long.MAX_VALUE,2));invalid(()->value(-1,2));
        Service s=new Service();s.add("P1","But",10000,5);s.add("P2","So",20000,2);List<Snapshot> before=s.snapshot();
        check(s.sell(new String[]{"P1","P1","P2"},new int[]{1,2,1})==50000);check(s.stock("P1")==2&&s.stock("P2")==1);
        check(before.get(0).stock==2&&before.get(1).stock==5);
        invalid(()->s.sell(new String[]{"P1","P2"},new int[]{1,9}));check(s.stock("P1")==2&&s.stock("P2")==1);
        invalid(()->s.sell(new String[]{"P1"},new int[]{0}));invalid(()->s.sell(new String[]{"UNKNOWN"},new int[]{1}));
        invalid(()->s.sell(new String[]{"P1"},new int[0]));check(s.sell(new String[0],new int[0])==0);
        check(s.command("SELL;P1;abc").equals("ERR"));check(s.command("SELL;P1;1").equals("10000"));check(s.stock("P1")==1);
        Service large=new Service();large.add("A","A",Long.MAX_VALUE,2);large.add("B","B",1,1);
        overflow(()->large.sell(new String[]{"A"},new int[]{2}));check(large.stock("A")==2);
        overflow(()->large.sell(new String[]{"A","B"},new int[]{1,1}));check(large.stock("A")==2&&large.stock("B")==1);
        overflow(()->large.sell(new String[]{"A","A"},new int[]{Integer.MAX_VALUE,1}));check(large.stock("A")==2);
        Service tied=new Service();tied.add("P2","Two",10,1);tied.add("P1","One",10,1);check(tied.snapshot().get(0).id.equals("P1"));
        List<Snapshot> external=s.snapshot();external.clear();check(s.snapshot().size()==2);check(s.command("EXIT").equals("BYE"));
        console(s,new Scanner("SELL;P1;abc\nLIST\nEXIT\n"));console(new Service(),new Scanner(""));
        System.out.println("OK exercises/mini_projects/product_management");
    }
}

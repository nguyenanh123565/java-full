package oop.exercises.solutions;
class Line {
    private String name;private long unitPrice;private int quantity;
    Line(String name,long unitPrice,int quantity){
        this.name=name==null||name.isEmpty()?"Unnamed":name;
        this.unitPrice=unitPrice>=0&&unitPrice<=1000000?unitPrice:0;
        this.quantity=quantity>=1&&quantity<=100?quantity:1;
    }
    String getName(){return name;}long getUnitPrice(){return unitPrice;}int getQuantity(){return quantity;}
    long total(){return unitPrice*quantity;}
}
class Product {
    private String name;private long price;
    Product(String name,long price){this.name=name;this.price=price;}
    String getName(){return name;}long getPrice(){return price;}
    boolean changePrice(long price){if(price<0||price>1000000)return false;this.price=price;return true;}
}
class SmallStore {
    private Line[] lines=new Line[2];private int count;
    boolean add(Line line){if(line==null||count>=lines.length)return false;lines[count]=line;count++;return true;}
    int getCount(){return count;}Line get(int i){return i>=0&&i<count?lines[i]:null;}
}
interface Sender {String render(String message);}
class EmailSender implements Sender {@Override public String render(String m){return "EMAIL:"+(m==null?"":m);}}
class SmsSender implements Sender {@Override public String render(String m){return "SMS:"+(m==null?"":m);}}
class PushSender implements Sender {@Override public String render(String m){return "PUSH:"+(m==null?"":m);}}
abstract class PrefixSender implements Sender {
    private String prefix;
    PrefixSender(String prefix){this.prefix=prefix==null?"":prefix;}
    abstract String channelName();
    @Override public String render(String message){return prefix+channelName()+":"+(message==null?"":message);}
}
class PrefixEmailSender extends PrefixSender {
    PrefixEmailSender(String p){super(p);}
    @Override String channelName(){return "EMAIL";}
}
interface ReceiptFormat {String render(String id,long total);}
class PlainFormat implements ReceiptFormat {@Override public String render(String id,long total){return id+":"+total;}}
class BracketFormat implements ReceiptFormat {@Override public String render(String id,long total){return "["+id+":"+total+"]";}}
class Receipt {
    private String id;private long total;private ReceiptFormat format;
    Receipt(String id,long total,ReceiptFormat format){this.id=id==null||id.isEmpty()?"DRAFT":id;this.total=total<0?0:total;this.format=format==null?new PlainFormat():format;}
    String render(){return format.render(id,total);}
}
class Order {
    private String id;private Line[] lines=new Line[10];private int count;private boolean confirmed;
    Order(String id){this.id=id==null||id.isEmpty()?"DRAFT":id;}
    String getId(){return id;}int getCount(){return count;}boolean isConfirmed(){return confirmed;}
    long total(){long total=0;for(int i=0;i<count;i++)total+=lines[i].total();return total;}
    boolean add(String name,long unitPrice,int quantity){
        if(confirmed||count>=lines.length||name==null||name.isEmpty()||unitPrice<0||unitPrice>1000000||quantity<1||quantity>100)return false;
        lines[count]=new Line(name,unitPrice,quantity);count++;return true;
    }
    boolean confirm(){if(confirmed||count==0)return false;confirmed=true;return true;}
}
class NotificationService {
    String[] create(Order order,Sender[] senders){
        if(order==null||!order.isConfirmed()||senders==null||senders.length==0)return new String[0];
        for(Sender sender:senders)if(sender==null)return new String[0];
        String[] messages=new String[senders.length];String body=order.getId()+":"+order.total();
        for(int i=0;i<senders.length;i++)messages[i]=senders[i].render(body);
        return messages;
    }
}
public class ReferenceSolution {
    static void check(boolean ok,String id){if(!ok)throw new AssertionError(id);}
    public static void main(String[] args){
        Line pen=new Line("Pen",2000,3),bad=new Line(null,-1,0);
        check(pen.total()==6000&&bad.getName().equals("Unnamed")&&bad.getUnitPrice()==0&&bad.getQuantity()==1&&bad.total()==0,"OOP-01");
        check(new Line("Max",1000000,100).total()==100000000&&new Line("",1000001,101).total()==0,"OOP-01 bounds");
        Product p=new Product("Book",100);Line snapshot=new Line(p.getName(),p.getPrice(),2);p.changePrice(120);
        check(snapshot.total()==200&&p.getPrice()==120&&!p.changePrice(-1)&&p.getPrice()==120,"OOP-02");
        SmallStore store=new SmallStore();check(!store.add(null)&&store.getCount()==0&&store.get(0)==null,"OOP-03 null");
        check(store.add(pen)&&store.add(snapshot)&&!store.add(pen)&&store.getCount()==2&&store.get(0)==pen&&store.get(1)==snapshot,"OOP-03 full");
        check(new Receipt("A1",40000,null).render().equals("A1:40000")&&new Receipt(null,0,null).render().equals("DRAFT:0"),"OOP-04");
        Sender email=new EmailSender(),sms=new SmsSender();
        check(email.render("A1").equals("EMAIL:A1")&&sms.render("A1").equals("SMS:A1")&&email.render(null).equals("EMAIL:")&&new PrefixEmailSender("[SHOP]").render("A1").equals("[SHOP]EMAIL:A1")&&new PrefixEmailSender(null).render(null).equals("EMAIL:"),"OOP-05");
        check(new Receipt("A1",40000,new BracketFormat()).render().equals("[A1:40000]")&&new Receipt("",-1,null).render().equals("DRAFT:0"),"OOP-06");
        Order order=new Order("O1");check(!order.confirm()&&!order.isConfirmed(),"OOP-07 empty");
        check(!order.add(null,1,1)&&!order.add("",1,1)&&!order.add("X",-1,1)&&!order.add("X",1000001,1)&&!order.add("X",0,0)&&!order.add("X",0,101)&&order.getCount()==0&&order.total()==0,"OOP-07 invalid atomic");
        check(order.add("Pen",2000,3)&&order.add("Book",10000,2)&&order.total()==26000&&order.getCount()==2,"OOP-07 add");
        NotificationService service=new NotificationService();check(service.create(order,new Sender[]{email,sms}).length==0,"OOP-08 before confirm");
        check(order.confirm()&&!order.confirm()&&!order.add("X",1,1)&&order.total()==26000&&order.getCount()==2,"OOP-07 confirm");
        String[] first=service.create(order,new Sender[]{email,sms});check(first.length==2&&first[0].equals("EMAIL:O1:26000")&&first[1].equals("SMS:O1:26000"),"OOP-08 channels");
        String[] extended=service.create(order,new Sender[]{email,sms,new PushSender()});check(extended.length==3&&extended[2].equals("PUSH:O1:26000")&&extended[0].equals(first[0]),"OOP-08 extension");
        check(service.create(null,new Sender[]{email}).length==0&&service.create(order,null).length==0&&service.create(order,new Sender[0]).length==0&&service.create(order,new Sender[]{email,null}).length==0&&service.create(order,new Sender[]{null}).length==0,"OOP-08 invalid config");
        check(service.create(order,new Sender[]{email,sms})[0].equals(first[0])&&order.isConfirmed()&&order.total()==26000,"OOP-08 repeated");
        Order full=new Order(null);for(int i=0;i<10;i++)check(full.add("Max",1000000,100),"OOP-07 fill");
        check(full.total()==1000000000L&&full.getCount()==10&&!full.add("Overflow",1,1)&&full.getCount()==10&&full.getId().equals("DRAFT"),"OOP-07 full and max");
        Order free=new Order("");check(free.add("Gift",0,1)&&free.confirm()&&free.total()==0,"OOP-07 zero price");
        System.out.println("PASS OOP-01..08 (don hang + EMAIL/SMS/PUSH; mo phong, khong gui mang)");
    }
}

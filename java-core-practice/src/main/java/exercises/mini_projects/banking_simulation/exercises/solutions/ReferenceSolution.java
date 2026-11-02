package exercises.mini_projects.banking_simulation.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    private static void text(String s){if(s==null||s.isBlank())throw new IllegalArgumentException("Chuỗi rỗng");}
    private static class Account {private final String id;private long balance;Account(String id,long balance){text(id);if(balance<0)throw new IllegalArgumentException("Âm");this.id=id;this.balance=balance;}}
    private static class Transfer {
        private final String from,to;private final long amount;
        Transfer(String from,String to,long amount){this.from=from;this.to=to;this.amount=amount;}
        boolean same(String f,String t,long a){return from.equals(f)&&to.equals(t)&&amount==a;}
    }
    public static class Bank {
        private final Map<String,Account> accounts=new LinkedHashMap<>();
        private final Map<String,Transfer> done=new HashMap<>();
        public void add(String id,long balance){Account a=new Account(id,balance);if(accounts.containsKey(id))throw new IllegalArgumentException("Trùng mã");accounts.put(id,a);}
        public long balance(String id){Account a=accounts.get(id);if(a==null)throw new IllegalArgumentException("Không có tài khoản");return a.balance;}
        public boolean transfer(String tx,String from,String to,long amount){
            text(tx);text(from);text(to);Transfer previous=done.get(tx);
            if(previous!=null){if(previous.same(from,to,amount))return false;throw new IllegalArgumentException("Xung đột mã lệnh");}
            Account source=accounts.get(from),target=accounts.get(to);
            if(source==null||target==null||from.equals(to)||amount<=0||source.balance<amount)throw new IllegalArgumentException("Không thể chuyển");
            long nextTarget=Math.addExact(target.balance,amount);
            source.balance-=amount;target.balance=nextTarget;done.put(tx,new Transfer(from,to,amount));return true;
        }
        public Map<String,Long> snapshot(){Map<String,Long> out=new LinkedHashMap<>();for(Account a:accounts.values())out.put(a.id,a.balance);return out;}
        public long total(){long sum=0;for(Account a:accounts.values())sum=Math.addExact(sum,a.balance);return sum;}
        public String command(String line){try{String[] p=line.split(";",-1);if(p.length==1&&p[0].equals("EXIT"))return "BYE";if(p.length==1&&p[0].equals("BALANCES"))return snapshot().toString();if(p.length==5&&p[0].equals("TRANSFER"))return transfer(p[1],p[2],p[3],Long.parseLong(p[4]))?"OK":"DUPLICATE";return "ERR";}catch(IllegalArgumentException|ArithmeticException ex){return "ERR";}}
    }
    public static void console(Bank bank,Scanner input){while(input.hasNextLine()){String result=bank.command(input.nextLine());System.out.println(result);if(result.equals("BYE"))break;}}
    private static void overflow(Runnable action){try{action.run();}catch(ArithmeticException expected){return;}throw new AssertionError("Phải phát hiện overflow");}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        Bank b=new Bank();b.add("A",100);b.add("B",40);Map<String,Long> old=b.snapshot();
        check(b.transfer("T1","A","B",30));check(b.balance("A")==70&&b.balance("B")==70);check(b.total()==140);
        check(!b.transfer("T1","A","B",30));invalid(()->b.transfer("T1","A","B",20));check(old.get("A")==100&&old.get("B")==40);
        invalid(()->b.transfer("T2","A","B",71));check(b.balance("A")==70&&b.balance("B")==70);
        invalid(()->b.transfer("bad","A","A",1));invalid(()->b.transfer("bad","A","UNKNOWN",1));invalid(()->b.transfer("bad","A","B",0));
        check(b.transfer("T3","B","A",70));check(b.balance("A")==140&&b.balance("B")==0&&b.total()==140);
        check(!b.transfer("T3","B","A",70));check(b.transfer("T2","A","B",71));check(b.total()==140);
        Map<String,Long> external=b.snapshot();external.put("A",0L);external.clear();check(b.balance("A")==69);
        Bank large=new Bank();large.add("A",100);large.add("B",Long.MAX_VALUE);overflow(()->large.transfer("T","A","B",1));check(large.balance("A")==100&&large.balance("B")==Long.MAX_VALUE);overflow(large::total);
        invalid(()->b.add("A",0));invalid(()->b.add("C",-1));
        check(b.command("TRANSFER;T9;A;B;abc").equals("ERR"));check(b.command("BALANCES").equals("{A=69, B=71}"));check(b.command("EXIT").equals("BYE"));
        console(b,new Scanner("TRANSFER;T9;A;B;abc\nBALANCES\nEXIT\n"));console(new Bank(),new Scanner(""));
        System.out.println("OK exercises/mini_projects/banking_simulation");
    }
}

package oop.inheritance.exercises.solutions;
class Ticket {
    private String event;
    Ticket(String event) { this.event = event == null || event.isEmpty() ? "Unknown" : event; }
    String getEvent() { return event; }
    int price() { return 100; }
}
class ReservedTicket extends Ticket {
    private String seat;
    ReservedTicket(String event,String seat) { super(event); this.seat = seat == null || seat.isEmpty() ? "Free" : seat; }
    String describe() { return getEvent() + "/" + seat; }
    @Override int price() { return 150; }
}
class DiscountTicket extends Ticket { DiscountTicket(String e) { super(e); } @Override int price() { return 60; } }
class ComplimentaryTicket extends Ticket { ComplimentaryTicket(String e) { super(e); } @Override int price() { return 0; } }
class FixedReservedTicket extends Ticket { FixedReservedTicket(String e) { super(e); } }
public class ReferenceSolution {
    static void check(boolean ok,String id) { if (!ok) throw new AssertionError(id); }
    static int sumPrices(Ticket[] tickets) { int sum=0; if (tickets != null) for (Ticket t:tickets) if (t != null) sum += t.price(); return sum; }
    public static void main(String[] args) {
        ReservedTicket r = new ReservedTicket("Music","A1");
        check(r.describe().equals("Music/A1") && new ReservedTicket(null,"").describe().equals("Unknown/Free"),"INH-01");
        Ticket t = r; check(t == r && t.getEvent().equals("Music") && t != new Ticket("Music"),"INH-02");
        check(new FixedReservedTicket("Music").getEvent().equals("Music") && new FixedReservedTicket(null).getEvent().equals("Unknown"),"INH-03");
        check(sumPrices(new Ticket[]{new Ticket("A"),new DiscountTicket("B"),new ComplimentaryTicket("C"),null}) == 160,"INH-04");
        check(sumPrices(new Ticket[]{new Ticket("Talk"),r,new DiscountTicket("Film")}) == 310 && sumPrices(new Ticket[]{r,r}) == 300,"INH-05");
        check(sumPrices(null) == 0 && sumPrices(new Ticket[0]) == 0 && sumPrices(new Ticket[]{null}) == 0,"INH-05 empty");
        System.out.println("PASS INH-01..05; Receipt la has-a, xem giai thich trong README loi giai");
    }
}

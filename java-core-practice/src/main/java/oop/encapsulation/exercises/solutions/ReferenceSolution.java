package oop.encapsulation.exercises.solutions;
class Bin {
    private int capacity; private int quantity;
    Bin(int capacity) { this.capacity = capacity >= 1 && capacity <= 100 ? capacity : 1; }
    int getQuantity() { return quantity; }
    boolean add(int amount) { if (amount <= 0 || amount > capacity - quantity) return false; quantity += amount; return true; }
    boolean remove(int amount) { if (amount <= 0 || amount > quantity) return false; quantity -= amount; return true; }
}
class Room {
    private int capacity; private int booked;
    Room(int capacity) { this.capacity = capacity >= 1 && capacity <= 100 ? capacity : 1; }
    int getCapacity() { return capacity; } int getBooked() { return booked; }
    boolean book(int seats) { if (seats <= 0 || seats > capacity - booked) return false; booked += seats; return true; }
    boolean cancel(int seats) { if (seats <= 0 || seats > booked) return false; booked -= seats; return true; }
    boolean resize(int next) { if (next < 1 || next > 100 || next < booked) return false; capacity = next; return true; }
}
class TimeWindow {
    private int start; private int end = 1;
    int getStart() { return start; } int getEnd() { return end; }
    boolean reschedule(int start,int end) {
        if (start < 0 || start >= end || end > 24) return false;
        this.start = start; this.end = end; return true;
    }
}
public class ReferenceSolution {
    static void check(boolean ok, String id) { if (!ok) throw new AssertionError(id); }
    static int totalBooked(Room[] rooms) { int total = 0; if (rooms != null) for (Room r : rooms) if (r != null) total += r.getBooked(); return total; }
    public static void main(String[] args) {
        Bin bin = new Bin(5);
        check(bin.add(3) && !bin.add(3) && bin.getQuantity() == 3 && bin.remove(3) && bin.getQuantity() == 0, "ENC-01");
        check(!bin.add(0) && !bin.add(-1) && !bin.remove(1) && bin.add(5) && !bin.add(1), "ENC-01 bounds");
        Bin fallback = new Bin(0); check(fallback.add(1) && !fallback.add(1), "ENC-01 constructor");
        Room room = new Room(5); check(room.book(4), "ENC-02 setup");
        check(!room.resize(3) && room.getCapacity() == 5 && room.getBooked() == 4, "ENC-02");
        check(!room.book(2) && !room.book(0) && !room.book(-1) && room.getBooked() == 4, "ENC-03 reject");
        check(room.book(1) && !room.book(1) && room.getBooked() == 5, "ENC-03 exact");
        TimeWindow window = new TimeWindow(); check(window.reschedule(9,12), "ENC-04 setup");
        check(!window.reschedule(14,13) && !window.reschedule(12,12) && !window.reschedule(-1,5) && !window.reschedule(23,25) && window.getStart() == 9 && window.getEnd() == 12, "ENC-04 invalid");
        check(window.reschedule(0,24), "ENC-04 bounds");
        Room first = new Room(5), second = new Room(2);
        check(first.book(4) && !first.resize(3) && first.cancel(2) && first.resize(3) && second.book(1), "ENC-05 chain");
        check(first.getCapacity() == 3 && first.getBooked() == 2 && totalBooked(new Room[]{first,null,second}) == 3, "ENC-05 total");
        check(!first.cancel(0) && !first.cancel(-1) && !first.cancel(3) && !first.resize(0) && !first.resize(101) && first.resize(2), "ENC-05 bounds");
        check(totalBooked(null) == 0 && totalBooked(new Room[0]) == 0, "ENC-05 empty");
        System.out.println("PASS ENC-01..05");
    }
}

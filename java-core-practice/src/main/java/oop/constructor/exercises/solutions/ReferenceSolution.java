package oop.constructor.exercises.solutions;
class Timer {
    String label; int minutes;
    Timer(String label, int minutes) {
        this.label = label == null || label.isEmpty() ? "Timer" : label;
        this.minutes = minutes >= 0 && minutes <= 120 ? minutes : 0;
    }
    String describe() { return label + ":" + minutes; }
}
class Ticket {
    String trace;
    Ticket() { this("A"); trace += "2"; }
    Ticket(String code) { trace = "1" + code; }
}
// CTOR-03: doi ten class de cung ton tai voi Timer cua CTOR-01.
class FixedTimer {
    int minutes;
    FixedTimer(int minutes){this.minutes=minutes;}
}
class Seat {
    String row; int number;
    Seat() { this("A",1); }
    Seat(String row) { this(row,1); }
    Seat(String row, int number) {
        this.row = row == null || row.isEmpty() ? "A" : row;
        this.number = number >= 1 && number <= 20 ? number : 1;
    }
    String describe() { return row + "-" + number; }
}
class Appointment {
    String title; int minutes;
    Appointment(String title, int minutes) {
        this.title = title == null || title.isEmpty() ? "Timer" : title;
        this.minutes = minutes >= 0 && minutes <= 120 ? minutes : 0;
    }
    Appointment(Appointment other) { this(other == null ? null : other.title, other == null ? 0 : other.minutes); }
}
public class ReferenceSolution {
    static void check(boolean ok, String id) { if (!ok) throw new AssertionError(id); }
    static int total(Appointment[] entries) { int sum = 0; for (Appointment a : entries) sum += a.minutes; return sum; }
    public static void main(String[] args) {
        check(new Timer("Tea",5).describe().equals("Tea:5") && new Timer(null,-1).describe().equals("Timer:0"), "CTOR-01");
        check(new Timer("",120).describe().equals("Timer:120") && new Timer("X",121).minutes == 0, "CTOR-01 bounds");
        check((new Ticket().trace + "3").equals("1A23") && new Ticket("B").trace.equals("1B"), "CTOR-02");
        check(new FixedTimer(7).minutes == 7 && new FixedTimer(0).minutes == 0, "CTOR-03");
        check(new Seat().describe().equals("A-1") && new Seat("B").describe().equals("B-1"), "CTOR-04 defaults");
        check(new Seat("C",20).describe().equals("C-20") && new Seat("",21).describe().equals("A-1") && new Seat(null,0).describe().equals("A-1"), "CTOR-04 bounds");
        Appointment original = new Appointment("Review",30); Appointment copy = new Appointment(original); copy.minutes = 45;
        check(original != copy && original.minutes == 30 && total(new Appointment[]{original,copy}) == 75, "CTOR-05");
        check(new Appointment(null).title.equals("Timer") && total(new Appointment[0]) == 0, "CTOR-05 empty");
        System.out.println("PASS CTOR-01..05 (trace duoc luu vao String de kiem tra)");
    }
}

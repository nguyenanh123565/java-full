package oop.class_object.exercises.solutions;

class Counter {
    int value;
    void increment() { value++; }
    int read() { return value; }
}
class Sensor {
    int reading;
    boolean update(int value) {
        if (value < -50 || value > 100) return false;
        reading = value;
        return true;
    }
    int read() { return reading; }
}
public class ReferenceSolution {
    static void replace(Counter c) { c = new Counter(); c.value = 99; }
    static int countAbove(Sensor[] sensors, int threshold) {
        if (sensors == null) return 0;
        int count = 0;
        for (Sensor sensor : sensors) if (sensor != null && sensor.read() > threshold) count++;
        return count;
    }
    static void check(boolean ok, String id) { if (!ok) throw new AssertionError(id); }
    public static void main(String[] args) {
        Counter first = new Counter(), second = new Counter();
        first.increment(); first.increment(); second.increment();
        check(first.read() == 2 && second.read() == 1, "OBJ-01");
        Counter a = new Counter(); Counter b = a; b.value = 4; replace(b);
        check(a.value == 4 && a == b, "OBJ-02");
        Counter[] gates = new Counter[2];
        for (int i = 0; i < gates.length; i++) gates[i] = new Counter();
        gates[0].increment();
        check(gates[0].read() == 1 && gates[1].read() == 0 && gates[0] != gates[1], "OBJ-03");
        Sensor sensor = new Sensor();
        check(sensor.update(25) && !sensor.update(101) && sensor.read() == 25, "OBJ-04 reject");
        check(!sensor.update(-51) && sensor.update(-50) && sensor.update(0) && sensor.update(100), "OBJ-04 bounds");
        Sensor low = new Sensor(); low.update(10); Sensor high = new Sensor(); high.update(40);
        check(countAbove(new Sensor[]{low, null, high},20) == 1, "OBJ-05 normal");
        check(countAbove(new Sensor[]{high,high},20) == 2 && countAbove(new Sensor[]{high},40) == 0, "OBJ-05 identity");
        check(countAbove(null,0) == 0 && countAbove(new Sensor[0],0) == 0 && countAbove(new Sensor[]{null},0) == 0, "OBJ-05 empty");
        System.out.println("PASS OBJ-01..05");
    }
}

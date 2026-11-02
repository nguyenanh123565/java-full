package exception.custom_exception.exercises.solutions;



/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static final class SeatsUnavailableException extends Exception {
        private static final long serialVersionUID=1L;
        private final String section;
        private final int requested, available;
        SeatsUnavailableException(String section, int requested, int available) {
            super("Khu "+section+": cần "+requested+", còn "+available);
            this.section=section;
            this.requested=requested;
            this.available=available;
        }
        String getSection() {
            return section;
        }
        int getRequested() {
            return requested;
        }
        int getAvailable() {
            return available;
        }
    }
    static int reserve(int available, int requested)throws SeatsUnavailableException {
        if(available<0||requested<=0)throw new IllegalArgumentException("count");
        if(requested>available)throw new SeatsUnavailableException("main", requested, available);
        return available-requested;
    }
    static final class Workshop {
        private final int capacity;
        private int available;
        Workshop(int capacity) {
            if(capacity<0)throw new IllegalArgumentException("capacity");
            this.capacity=capacity;
            available=capacity;
        }
        void reserve(int count)throws SeatsUnavailableException {
            available=ReferenceSolution.reserve(available, count);
        }
        void cancel(int count) {
            if(count<=0||count>capacity-available)throw new IllegalArgumentException("cancel");
            available+=count;
        }
        int available() {
            return available;
        }
    }
    static final class Booking {
        private int a, b;
        Booking(int a, int b) {
            if(a<0||b<0)throw new IllegalArgumentException("capacity");
            this.a=a;
            this.b=b;
        }
        void bookPair(int x, int y)throws SeatsUnavailableException {
            if(x<0||y<0||(x==0&&y==0))throw new IllegalArgumentException("pair");
            if(x>a)throw new SeatsUnavailableException("A", x, a);
            if(y>b)throw new SeatsUnavailableException("B", y, b);
            a-=x;
            b-=y;
        }
        int availableA() {
            return a;
        }
        int availableB() {
            return b;
        }
    }
    static void run()throws SeatsUnavailableException {
        check(reserve(5, 2)==3&&reserve(2, 2)==0, "CE-01 reserve");
        try {
            reserve(2, 3);
            throw new AssertionError("CE-01 shortage");
        }
        catch(SeatsUnavailableException e) {
            check(e.getRequested()==3&&e.getAvailable()==2&&!e.getMessage().isEmpty(), "CE-01 data");
        }
        Workshop sequence=new Workshop(4);
        int[] states=new int[3];
        int index=0;
        for(int amount:new int[] {
            3, 2, 1
        }) {
            try {
                sequence.reserve(amount);
            }
            catch(SeatsUnavailableException expected) {
            }
            states[index++]=sequence.available();
        }
        check(states[0]==1&&states[1]==1&&states[2]==0, "CE-02 per request");
        Workshop stable=new Workshop(2);
        try {
            stable.reserve(3);
            throw new AssertionError("CE-03 shortage");
        }
        catch(SeatsUnavailableException e) {
            check(stable.available()==2&&e.getAvailable()==2, "CE-03 unchanged");
        }
        Workshop workshop=new Workshop(5);
        workshop.reserve(3);
        workshop.cancel(2);
        check(workshop.available()==4, "CE-04 cancel");
        try {
            workshop.cancel(2);
            throw new AssertionError("CE-04 invalid");
        }
        catch(IllegalArgumentException expected) {
        }
        check(workshop.available()==4, "CE-04 unchanged");
        Booking booking=new Booking(2, 1);
        try {
            booking.bookPair(1, 2);
            throw new AssertionError("CE-05 shortage");
        }
        catch(SeatsUnavailableException e) {
            check("B".equals(e.getSection())&&booking.availableA()==2&&booking.availableB()==1, "CE-05 atomic state");
        }
        booking.bookPair(1, 1);
        check(booking.availableA()==1&&booking.availableB()==0, "CE-05 success");
        try {
            booking.bookPair(0, 0);
            throw new AssertionError("CE-05 invalid");
        }
        catch(IllegalArgumentException expected) {
        }
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS CE: 5 bài");
    }
}

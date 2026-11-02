package static_final.exercises.solutions;

public class ReferenceSolution {
    public static class SeatPool {
        public static final int CAPACITY=3; private int used;
        public int used(){return used;}
        public boolean reserve(){if(used>=CAPACITY)return false;used++;return true;}
    }
    public static class Wallet {
        private int balance;private static int created;
        public Wallet(int initial){if(initial<0||initial>1_000_000)throw new IllegalArgumentException("initial");balance=initial;created++;}
        public int balance(){return balance;}public static int created(){return created;}
    }
    public static class Schedule {
        private final int[][] values;
        public Schedule(int[][] source){values=copy(source);}
        private static int[][] copy(int[][] source){
            if(source==null)throw new IllegalArgumentException("null schedule");
            int[][] result=new int[source.length][];
            for(int r=0;r<source.length;r++){
                if(source[r]==null)throw new IllegalArgumentException("null row");
                result[r]=new int[source[r].length];
                for(int c=0;c<source[r].length;c++){
                    if(source[r][c]<0||source[r][c]>1_000_000)throw new IllegalArgumentException("capacity");
                    result[r][c]=source[r][c];
                }
            }return result;
        }
        public int[][] snapshot(){return copy(values);}
        public long total(){long total=0;for(int[] row:values)for(int n:row)total+=n;return total;}
    }
    public static class LimitedCart {
        public static final int MAX_SLOTS=3;private final int[] quantities=new int[MAX_SLOTS];
        private static long acceptedCalls;
        public boolean add(int index,int amount){
            if(index<0||index>=MAX_SLOTS||amount<=0||amount>99-quantities[index])return false;
            quantities[index]+=amount;acceptedCalls++;return true;
        }
        public int[] snapshot(){return quantities.clone();}public static long acceptedCalls(){return acceptedCalls;}
    }
    public static void main(String[] args){
        SeatPool a=new SeatPool(),b=new SeatPool();assert a.used()==0&&b.used()==0;
        assert a.reserve()&&a.reserve()&&a.reserve()&&!a.reserve()&&!a.reserve();
        assert b.reserve()&&a.used()==3&&b.used()==1;
        final int[] limits={3};int[] alias=limits;alias[0]=5;assert limits[0]==5;
        limits[0]=7;final int maximum=3;int x=maximum+1;assert x==4&&limits[0]==7;
        int before=Wallet.created();Wallet wa=new Wallet(10),wb=new Wallet(20);
        assert wa.balance()==10&&wb.balance()==20&&Wallet.created()==before+2;
        try{new Wallet(-1);throw new AssertionError("accepted negative");}catch(IllegalArgumentException expected){}
        assert Wallet.created()==before+2;
        assert new Wallet(0).balance()==0;
        int count=Wallet.created();try{new Wallet(1_000_001);throw new AssertionError("accepted large");}catch(IllegalArgumentException expected){}
        assert Wallet.created()==count;
        int[][] source={{1,2},{},{3}};Schedule schedule=new Schedule(source);source[0][0]=99;
        int[][] snap=schedule.snapshot();snap[2][0]=88;assert schedule.total()==6;
        assert schedule.snapshot()!=snap&&schedule.snapshot()[0]!=source[0];
        assert new Schedule(new int[0][]).total()==0&&new Schedule(new int[][]{{},{}}).total()==0;
        try{new Schedule(null);throw new AssertionError("null");}catch(IllegalArgumentException expected){}
        try{new Schedule(new int[][]{null});throw new AssertionError("null row");}catch(IllegalArgumentException expected){}
        try{new Schedule(new int[][]{{-1}});throw new AssertionError("negative");}catch(IllegalArgumentException expected){}
        LimitedCart ca=new LimitedCart(),cb=new LimitedCart();long calls=LimitedCart.acceptedCalls();
        assert ca.add(0,2)&&cb.add(1,3)&&LimitedCart.acceptedCalls()==calls+2;
        assert !ca.add(0,98)&&ca.snapshot()[0]==2;
        assert !ca.add(-1,1)&&!ca.add(3,1)&&!ca.add(0,0)&&!ca.add(0,-1)&&!ca.add(0,Integer.MAX_VALUE);
        assert ca.add(0,97)&&ca.snapshot()[0]==99&&!ca.add(0,1);
        int[] external=ca.snapshot();external[0]=0;assert ca.snapshot()[0]==99&&cb.snapshot()[1]==3;
        assert LimitedCart.acceptedCalls()==calls+3;
        System.out.println("STF: OK");
    }
}

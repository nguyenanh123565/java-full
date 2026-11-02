package equals_hashcode.exercises.solutions;



/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static final class Point {
        private final int x, y;
        Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
        public boolean equals(Object other) {
            if(!(other instanceof Point))return false;
            Point p=(Point)other;
            return x==p.x&&y==p.y;
        }
        public int hashCode() {
            return 31*Integer.hashCode(x)+Integer.hashCode(y);
        }
    }
    static final class Key {
        private final String id;
        Key(String id) {
            if(id==null)throw new IllegalArgumentException("id");
            this.id=id;
        }
        public boolean equals(Object other) {
            return other instanceof Key&&id.equals(((Key)other).id);
        }
        public int hashCode() {
            return id.hashCode();
        }
    }
    static final class EditionKey {
        private final String isbn;
        private final int edition;
        EditionKey(String isbn, int edition) {
            if(isbn==null||isbn.trim().isEmpty()||edition<=0)throw new IllegalArgumentException("edition");
            this.isbn=isbn;
            this.edition=edition;
        }
        public boolean equals(Object other) {
            if(!(other instanceof EditionKey))return false;
            EditionKey key=(EditionKey)other;
            return isbn.equals(key.isbn)&&edition==key.edition;
        }
        public int hashCode() {
            return 31*isbn.hashCode()+edition;
        }
    }
    static boolean same(Object a, Object b) {
        return a==b||(a!=null&&a.equals(b));
    }
    static int uniqueCount(Object[] values) {
        int count=0;
        for(int i=0; i<values.length; i++) {
            boolean seen=false;
            for(int j=0; j<i; j++)if(same(values[i], values[j])) {
                seen=true;
                break;
            }
            if(!seen)count++;
        }
        return count;
    }
    static void run() {
        Point a=new Point(2, 3), b=new Point(2, 3);
        check(a!=b&&a.equals(b)&&a.hashCode()==b.hashCode()&&!a.equals(new Point(3, 2))&&!a.equals(null)&&!a.equals("2,3"), "EQ-01 point");
        Point x=new Point(1, 1), y=new Point(1, 1), z=new Point(1, 1);
        check(x.equals(x)&&x.equals(y)&&y.equals(x)&&y.equals(z)&&x.equals(z), "EQ-02 contracts");
        Point collision=new Point(0, 32);
        check(x.hashCode()==collision.hashCode()&&!x.equals(collision), "EQ-02 collision");
        Object key=new Key("A");
        check(key.equals(new Key("A"))&&key.hashCode()==new Key("A").hashCode()&&!key.equals(null), "EQ-03 override");
        EditionKey first=new EditionKey("ISBN-A", 1);
        check(first.equals(new EditionKey(new String("ISBN-A"), 1))&&!first.equals(new EditionKey("ISBN-A", 2)), "EQ-04 compound key");
        try {
            new EditionKey("", 1);
            throw new AssertionError("EQ-04 invalid");
        }
        catch(IllegalArgumentException expected) {
        }
        check(uniqueCount(new Object[] {
            first, new EditionKey("ISBN-A", 1), new EditionKey("ISBN-A", 2), null, null
        })==3, "EQ-05 keys/null");
        check(uniqueCount(new Object[] {
            new String("A"), "A"
        })==1&&uniqueCount(new Object[0])==0&&uniqueCount(new Object[] {
            null, null
        })==1, "EQ-05 boundary");
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS EQ: 5 bài");
    }
}

package exception.exercises.solutions;

import java.text.ParseException;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static int parseIntChecked(String text)throws ParseException {
        try {
            return Integer.parseInt(text);
        }
        catch(NumberFormatException e) {
            ParseException p=new ParseException("Số nguyên sai: "+text, 0);
            p.initCause(e);
            throw p;
        }
    }
    static int parseAge(String text)throws ParseException {
        int age=parseIntChecked(text);
        if(age<0)throw new IllegalArgumentException("age");
        return age;
    }
    static int propagatingCaller(String text)throws ParseException {
        return parseAge(text);
    }
    static String catchingCaller(String text) {
        try {
            return "OK:"+parseAge(text);
        }
        catch(ParseException e) {
            return "FORMAT";
        }
    }
    static final class Profile {
        private String name;
        private int age;
        Profile(String name, int age) {
            validate(name, age);
            this.name=name;
            this.age=age;
        }
        static void validate(String name, int age) {
            if(name==null||name.trim().isEmpty()||age<0||age>150)throw new IllegalArgumentException("profile");
        }
        void update(String nextName, String ageText)throws ParseException {
            int nextAge=parseAge(ageText);
            validate(nextName, nextAge);
            name=nextName;
            age=nextAge;
        }
    }
    static final class CapacityExceededException extends Exception {
        private static final long serialVersionUID=1L;
        final int requested, remaining;
        CapacityExceededException(int requested, int remaining) {
            super("Cần "+requested+", còn "+remaining);
            this.requested=requested;
            this.remaining=remaining;
        }
    }
    static final class Warehouse {
        private final int capacity;
        private int stored;
        Warehouse(int capacity) {
            if(capacity<0)throw new IllegalArgumentException("capacity");
            this.capacity=capacity;
        }
        void addLine(String text)throws ParseException, CapacityExceededException {
            int count=parseIntChecked(text);
            if(count<=0)throw new IllegalArgumentException("count");
            int remaining=capacity-stored;
            if(count>remaining)throw new CapacityExceededException(count, remaining);
            stored+=count;
        }
        int stored() {
            return stored;
        }
    }
    static void run()throws ParseException, CapacityExceededException {
        check(propagatingCaller("20")==20&&"FORMAT".equals(catchingCaller("abc")), "EX-01 callers");
        String[] inputs= {
            "2", "bad", "5"
        };
        int outer=0, inner=0;
        try {
            for(String text:inputs) {
                Integer.parseInt(text);
                outer++;
            }
        }
        catch(NumberFormatException expected) {
        }
        for(String text:inputs)try {
            Integer.parseInt(text);
            inner++;
        }
        catch(NumberFormatException expected) {
        }
        check(outer==1&&inner==2, "EX-02 policies");
        check(parseAge("0")==0, "EX-03 real zero");
        try {
            parseAge("abc");
            throw new AssertionError("EX-03 format");
        }
        catch(ParseException e) {
            check(e.getCause() instanceof NumberFormatException, "EX-03 cause");
        }
        Profile profile=new Profile("An", 20);
        try {
            profile.update("Bao", "bad");
            throw new AssertionError("EX-04 format");
        }
        catch(ParseException expected) {
        }
        check("An".equals(profile.name)&&profile.age==20, "EX-04 unchanged");
        profile.update("Bao", "25");
        check("Bao".equals(profile.name)&&profile.age==25, "EX-04 success");
        Warehouse warehouse=new Warehouse(5);
        String result="";
        for(String text:new String[] {
            "2", "x", "4", "3"
        })try {
            warehouse.addLine(text);
            result+="OK;";
        }
        catch(ParseException e) {
            result+="FORMAT;";
        }
        catch(CapacityExceededException e) {
            check(e.requested==4&&e.remaining==3, "EX-05 data");
            result+="CAPACITY;";
        }
        check("OK;FORMAT;CAPACITY;OK;".equals(result)&&warehouse.stored()==5, "EX-05 batch");
        try {
            warehouse.addLine("0");
            throw new AssertionError("EX-05 invalid");
        }
        catch(IllegalArgumentException expected) {
        }
        check(warehouse.stored()==5, "EX-05 unchanged");
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS EX: 5 bài");
    }
}

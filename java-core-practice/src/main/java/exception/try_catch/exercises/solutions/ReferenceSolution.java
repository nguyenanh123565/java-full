package exception.try_catch.exercises.solutions;



/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static int[] parseStats(String[] texts) {
        int ok=0, errors=0;
        for(String text:texts)try {
            Integer.parseInt(text);
            ok++;
        }
        catch(NumberFormatException e) {
            errors++;
        }
        return new int[] {
            ok, errors
        };
    }
    static String trace(String text) {
        String result="A";
        try {
            Integer.parseInt(text);
            result+="B";
        }
        catch(NumberFormatException e) {
            result+="C";
        }
        finally {
            result+="F";
        }
        return result+"Z";
    }
    static int read(String text) {
        try {
            return Integer.parseInt(text);
        }
        catch(NumberFormatException e) {
            return -1;
        }
    }
    static final class Probe implements AutoCloseable {
        boolean closed;
        public void close() {
            closed=true;
        }
    }
    static boolean closes(String text) {
        Probe probe=new Probe();
        try(probe) {
            Integer.parseInt(text);
        }
        catch(NumberFormatException expected) {
        }
        return probe.closed;
    }
    static final class Report {
        final long sum;
        final int valid, invalid;
        Report(long sum, int valid, int invalid) {
            this.sum=sum;
            this.valid=valid;
            this.invalid=invalid;
        }
    }
    static Report summarize(String[] texts) {
        long sum=0;
        int valid=0, invalid=0;
        for(String text:texts)try {
            int value=Integer.parseInt(text);
            sum+=value;
            valid++;
        }
        catch(NumberFormatException e) {
            invalid++;
        }
        return new Report(sum, valid, invalid);
    }
    static void run() {
        int[] stats=parseStats(new String[] {
            "12", "x", "-3", " 4 "
        });
        check(stats[0]==2&&stats[1]==2, "TC-01 stats");
        check(parseStats(new String[0])[0]==0&&parseStats(new String[] {
            null
        })[1]==1, "TC-01 boundary");
        check("ABFZ".equals(trace("5"))&&"ACFZ".equals(trace("bad")), "TC-02 flow");
        check(read("8")==8&&read("bad")==-1&&read("0")==0, "TC-03 return");
        check(closes("6")&&closes("x"), "TC-04 close both paths");
        Report result=summarize(new String[] {
            "10", "oops", "0", "-3"
        });
        check(result.sum==7&&result.valid==3&&result.invalid==1, "TC-05 report");
        check(summarize(new String[] {
            "2147483647", "2147483647"
        }).sum==4294967294L, "TC-05 long total");
        check(summarize(new String[0]).invalid==0, "TC-05 empty");
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS TC: 5 bài");
    }
}

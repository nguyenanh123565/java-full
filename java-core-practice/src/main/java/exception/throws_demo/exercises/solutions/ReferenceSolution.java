package exception.throws_demo.exercises.solutions;

import java.text.ParseException;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static ParseException error(String message, Throwable cause) {
        ParseException result=new ParseException(message, 0);
        if(cause!=null)result.initCause(cause);
        return result;
    }
    static int parseId(String text)throws ParseException {
        int result;
        try {
            result=Integer.parseInt(text);
        }
        catch(NumberFormatException e) {
            throw error("Id không đúng: "+text, e);
        }
        if(result<0)throw new IllegalArgumentException("id âm");
        return result;
    }
    static int middle(String text)throws ParseException {
        return parseId(text);
    }
    static int outer(String text)throws ParseException {
        return middle(text);
    }
    static int service(String text)throws ParseException {
        return parseId(text);
    }
    static int[] parsePoint(String text)throws ParseException {
        if(text==null)throw error("Điểm null", null);
        String[] parts=text.split(",", -1);
        if(parts.length!=2)throw error("Cần hai tọa độ", null);
        try {
            return new int[] {
                Integer.parseInt(parts[0]), Integer.parseInt(parts[1])
            };
        }
        catch(NumberFormatException e) {
            throw error("Tọa độ sai: "+text, e);
        }
    }
    static int[][] readAll(String[] lines)throws ParseException {
        int[][] result=new int[lines.length][];
        for(int i=0; i<lines.length; i++)try {
            result[i]=parsePoint(lines[i]);
        }
        catch(ParseException e) {
            throw error("Dòng "+(i+1), e);
        }
        return result;
    }
    static void run()throws ParseException {
        check(parseId("42")==42&&parseId("0")==0, "TH-01 valid");
        try {
            parseId("forty");
            throw new AssertionError("TH-01 invalid");
        }
        catch(ParseException e) {
            check(e.getCause() instanceof NumberFormatException&&e.getMessage().contains("forty"), "TH-01 cause");
        }
        try {
            parseId("-1");
            throw new AssertionError("TH-01 negative");
        }
        catch(IllegalArgumentException expected) {
        }
        String trace="";
        try {
            outer("x");
            trace+="OK";
        }
        catch(ParseException e) {
            trace+="ERROR";
        }
        trace+="END";
        check("ERROREND".equals(trace)&&outer("1")==1, "TH-02 propagation");
        check(service("0")==0, "TH-03 zero");
        try {
            service("x");
            throw new AssertionError("TH-03 fake id");
        }
        catch(ParseException expected) {
        }
        int[] point=parsePoint("3,-2");
        check(point[0]==3&&point[1]==-2, "TH-04 point");
        try {
            parsePoint("3,");
            throw new AssertionError("TH-04 empty coordinate");
        }
        catch(ParseException e) {
            check(e.getCause() instanceof NumberFormatException, "TH-04 cause");
        }
        check(readAll(new String[] {
            "1,2", "-3,4"
        })[1][0]==-3&&readAll(new String[0]).length==0, "TH-05 valid/empty");
        try {
            readAll(new String[] {
                "1,2", "x,3", "4,5"
            });
            throw new AssertionError("TH-05 fail fast");
        }
        catch(ParseException e) {
            check(e.getMessage().contains("2")&&e.getCause() instanceof ParseException&&e.getCause().getCause() instanceof NumberFormatException, "TH-05 line/cause");
        }
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS TH: 5 bài");
    }
}

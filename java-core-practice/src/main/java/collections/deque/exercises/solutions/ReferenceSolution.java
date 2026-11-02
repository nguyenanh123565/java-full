package collections.deque.exercises.solutions;

import java.util.*;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static List<String> takeEnds(Deque<String> values) {
        List<String> result=new ArrayList<>();
        if(!values.isEmpty())result.add(values.pollFirst());
        if(!values.isEmpty())result.add(values.pollLast());
        return result;
    }
    static boolean palindrome(String text) {
        Deque<Character> values=new ArrayDeque<>();
        for(int i=0; i<text.length(); i++)values.offerLast(text.charAt(i));
        while(values.size()>1)if(!values.pollFirst().equals(values.pollLast()))return false;
        return true;
    }
    static final class Editor {
        private String text="";
        private final Deque<String> undo=new ArrayDeque<>(), redo=new ArrayDeque<>();
        String text() {
            return text;
        }
        void append(String value) {
            if(value==null||value.isEmpty())throw new IllegalArgumentException("text");
            undo.push(text);
            text+=value;
            redo.clear();
        }
        boolean undo() {
            if(undo.isEmpty())return false;
            redo.push(text);
            text=undo.pop();
            return true;
        }
        boolean redo() {
            if(redo.isEmpty())return false;
            undo.push(text);
            text=redo.pop();
            return true;
        }
    }
    static void run() {
        Deque<String> values=new ArrayDeque<>(List.of("A", "B", "C"));
        check(takeEnds(values).equals(List.of("A", "C"))&&values.size()==1, "DQ-01 ends");
        check(takeEnds(values).equals(List.of("B"))&&takeEnds(values).isEmpty(), "DQ-01 boundary");
        Deque<String> trace=new ArrayDeque<>();
        trace.offerLast("A");
        trace.push("B");
        trace.offerLast("C");
        check("B".equals(trace.pop())&&"C".equals(trace.pollLast())&&"A".equals(trace.peek()), "DQ-02 trace");
        Editor roundTrip=new Editor();
        roundTrip.append("A");
        roundTrip.append("B");
        check(roundTrip.undo()&&roundTrip.undo()&&roundTrip.text().isEmpty()&&roundTrip.redo()&&"A".equals(roundTrip.text())&&roundTrip.redo()&&"AB".equals(roundTrip.text()), "DQ-03 redo order");
        check(palindrome("abba")&&palindrome("abcba")&&palindrome("")&&!palindrome("Abba")&&!palindrome("ab"), "DQ-04 palindrome");
        Editor editor=new Editor();
        check(!editor.undo()&&!editor.redo(), "DQ-05 empty");
        editor.append("A");
        editor.append("B");
        editor.undo();
        editor.append("C");
        check("AC".equals(editor.text())&&!editor.redo(), "DQ-05 branch");
        try {
            editor.append("");
            throw new AssertionError("DQ-05 invalid");
        }
        catch(IllegalArgumentException expected) {
        }
        check("AC".equals(editor.text())&&editor.undo()&&"A".equals(editor.text()), "DQ-05 unchanged history");
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS DQ: 5 bài");
    }
}

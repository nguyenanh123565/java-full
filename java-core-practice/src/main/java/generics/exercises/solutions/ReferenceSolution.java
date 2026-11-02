package generics.exercises.solutions;



/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static final class Pair<L, R> {
        private final L left;
        private final R right;
        Pair(L left, R right) {
            this.left=left;
            this.right=right;
        }
        L left() {
            return left;
        }
        R right() {
            return right;
        }
    }
    static final class Slot<T> {
        private T value;
        Slot(T value) {
            this.value=value;
        }
        T get() {
            return value;
        }
        void set(T value) {
            this.value=value;
        }
    }
    static <T extends Number> double sumSquares(T[] values) {
        if(values==null)throw new IllegalArgumentException("array");
        double result=0;
        for(T value:values) {
            if(value==null)throw new IllegalArgumentException("value");
            double x=value.doubleValue();
            result+=x*x;
        }
        return result;
    }
    static final class Result<T> {
        private final boolean success;
        private final T value;
        private final String error;
        private Result(boolean success, T value, String error) {
            this.success=success;
            this.value=value;
            this.error=error;
        }
        static <T> Result<T> success(T value) {
            if(value==null)throw new IllegalArgumentException("value");
            return new Result<>(true, value, null);
        }
        static <T> Result<T> failure(String error) {
            if(error==null||error.trim().isEmpty())throw new IllegalArgumentException("error");
            return new Result<>(false, null, error);
        }
        boolean isSuccess() {
            return success;
        }
        T value() {
            if(!success)throw new IllegalStateException(error);
            return value;
        }
        String error() {
            if(success)throw new IllegalStateException("success");
            return error;
        }
    }
    static void run() {
        Pair<String, Integer> pair=new Pair<>("An", 20);
        check(pair.left().length()==2&&pair.right()+1==21, "GEN-01 pair");
        Pair<Integer, String> reverse=new Pair<>(1, "A");
        check(reverse.left()==1&&"A".equals(reverse.right()), "GEN-01 reverse types");
        Slot<Integer> ints=new Slot<>(7);
        Slot<? extends Number> view=ints;
        check(view.get().doubleValue()==7.0, "GEN-02 wildcard");
        Slot<String> text=new Slot<>("Java");
        Slot<String> typed=text;
        typed.set("Core");
        check("Core".equals(text.get()), "GEN-03 typed alias");
        check(sumSquares(new Integer[] {
            2, -3
        })==13.0&&sumSquares(new Double[] {
            1.5, 2.0
        })==6.25&&sumSquares(new Integer[0])==0.0, "GEN-04 numeric types");
        try {
            sumSquares(new Integer[] {
                null
            });
            throw new AssertionError("GEN-04 null");
        }
        catch(IllegalArgumentException expected) {
        }
        Result<String> ok=Result.success("OK");
        Result<Integer> fail=Result.failure("Không đọc được");
        check(ok.isSuccess()&&"OK".equals(ok.value())&&!fail.isSuccess()&&!fail.error().isEmpty(), "GEN-05 states");
        try {
            fail.value();
            throw new AssertionError("GEN-05 wrong accessor");
        }
        catch(IllegalStateException expected) {
        }
        try {
            Result.success(null);
            throw new AssertionError("GEN-05 null");
        }
        catch(IllegalArgumentException expected) {
        }
        try {
            Result.failure("");
            throw new AssertionError("GEN-05 empty");
        }
        catch(IllegalArgumentException expected) {
        }
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS GEN: 5 bài");
    }
}

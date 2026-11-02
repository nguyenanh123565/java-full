package lambda.exercises.solutions;

import java.util.*;
import java.util.function.*;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static <T, R> List<R> process(List<T> source, Predicate<T> accept, Function<T, R> transform, Consumer<R> onResult) {
        List<R> result=new ArrayList<>();
        for(T value:source)if(accept.test(value)) {
            R mapped=transform.apply(value);
            result.add(mapped);
            onResult.accept(mapped);
        }
        return result;
    }
    static String chooseName(String name, Supplier<String> fallback) {
        return name==null||name.trim().isEmpty()?fallback.get():name.trim();
    }
    static void run() {
        Function<String, Integer> length=text->text.length();
        List<String> logs=new ArrayList<>();
        Consumer<String> log=text->logs.add(text);
        Supplier<String> fallback=()->"DEFAULT";
        check(length.apply("Java")==4&&length.apply("")==0&&logs.isEmpty(), "LAM-01 roles");
        log.accept("A");
        check(logs.equals(List.of("A"))&&"DEFAULT".equals(fallback.get()), "LAM-01 invoke");
        List<Integer> calls=new ArrayList<>();
        IntUnaryOperator op=value-> {
            calls.add(value);
            return value*2;
        };
        check(calls.isEmpty(), "LAM-02 lazy declaration");
        check(op.applyAsInt(3)==6&&calls.equals(List.of(3)), "LAM-02 first");
        check(op.applyAsInt(4)==8&&calls.equals(List.of(3, 4)), "LAM-02 second");
        int bonus=2;
        int capturedBonus=bonus;
        IntUnaryOperator add=value->value+capturedBonus;
        bonus=5;
        check(add.applyAsInt(3)==5&&bonus==5, "LAM-03 snapshot");
        Predicate<String> nonNull=text->text!=null;
        Predicate<String> nonBlank=text->!text.trim().isEmpty();
        Predicate<String> shortEnough=text->text.trim().length()<=5;
        Predicate<String> valid=nonNull.and(nonBlank).and(shortEnough);
        List<String> accepted=new ArrayList<>();
        for(String text:Arrays.asList(null, " A ", "      ", "ABCDEF", "BC"))if(valid.test(text))accepted.add(text);
        check(accepted.equals(List.of(" A ", "BC")), "LAM-04 safe predicate");
        List<String> source=Arrays.asList(" An ", "", null, "Bao");
        List<String> resultsLog=new ArrayList<>();
        List<String> result=process(source, nonNull.and(nonBlank), text->text.trim(), text->resultsLog.add(text));
        check(result.equals(List.of("An", "Bao"))&&resultsLog.equals(result)&&source.get(0).equals(" An "), "LAM-05 pipeline/source");
        List<String> supplierCalls=new ArrayList<>();
        Supplier<String> counted=()-> {
            supplierCalls.add("get");
            return "DEFAULT";
        };
        check("Chi".equals(chooseName("Chi", counted))&&supplierCalls.isEmpty(), "LAM-05 supplier not needed");
        check("DEFAULT".equals(chooseName(" ", counted))&&supplierCalls.size()==1, "LAM-05 supplier needed");
        List<Integer> lengths=process(List.of("AB", "C"), text->true, text->text.length(), n-> {
        });
        check(lengths.equals(List.of(2, 1)), "LAM-05 generic types");
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS LAM: 5 bài");
    }
}

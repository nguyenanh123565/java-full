package stream.exercises.solutions;

import java.util.*;
import java.util.stream.*;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static int totalNameLength(List<String> values) {
        return values.stream().filter(Objects::nonNull).map(String::trim).filter(text->!text.isEmpty()).mapToInt(String::length).sum();
    }
    static final class Product {
        final String id, category;
        final long price;
        final int stock;
        Product(String id, String category, long price, int stock) {
            if(id==null||id.trim().isEmpty()||category==null||category.trim().isEmpty()||price<0||price>1_000_000||stock<0||stock>1_000_000)throw new IllegalArgumentException("product");
            this.id=id;
            this.category=category;
            this.price=price;
            this.stock=stock;
        }
    }
    static long inventoryValue(List<Product> products) {
        return products.stream().filter(p->p.stock>0).map(p->p.price*p.stock).reduce(0L, Long::sum);
    }
    static final class Report {
        final long total;
        final Map<String, Long> counts;
        final List<String> ids;
        Report(long total, Map<String, Long> counts, List<String> ids) {
            this.total=total;
            this.counts=counts;
            this.ids=ids;
        }
    }
    static Report report(List<Product> products, int k) {
        if(k<0||products.size()>1000)throw new IllegalArgumentException("limits");
        Set<String> ids=new HashSet<>();
        for(Product p:products)if(!ids.add(p.id))throw new IllegalArgumentException("duplicate id");
        long total=inventoryValue(products);
        Map<String, Long> counts=products.stream().filter(p->p.stock>0).collect(Collectors.groupingBy(p->p.category, Collectors.counting()));
        List<String> top=products.stream().filter(p->p.stock>0).sorted(Comparator.comparingLong((Product p)->p.price).reversed().thenComparing(p->p.id)).limit(k).map(p->p.id).toList();
        return new Report(total, counts, top);
    }
    static void run() {
        check(totalNameLength(Arrays.asList(" An ", null, "", "Bao"))==5&&totalNameLength(List.of())==0, "STM-01 total");
        List<String> trace=new ArrayList<>();
        Stream<Integer> pipeline=List.of(1, 2, 3).stream().filter(n-> {
            trace.add("f"+n); return n%2!=0;
        }).map(n-> {
            trace.add("m"+n); return n*10;
        });
        check(trace.isEmpty(), "STM-02 lazy");
        List<Integer> mapped=pipeline.toList();
        check(mapped.equals(List.of(10, 30))&&trace.equals(List.of("f1", "m1", "f2", "f3", "m3")), "STM-02 flow");
        List<Integer> values=List.of(1, 2, 3);
        check(values.stream().mapToInt(Integer::intValue).sum()==6&&values.stream().count()==3, "STM-03 fresh streams");
        List<Product> products=List.of(new Product("A", "book", 100, 2), new Product("B", "book", 50, 0), new Product("C", "tool", 30, 3));
        check(inventoryValue(products)==290&&inventoryValue(List.of())==0, "STM-04 reduce");
        List<Product> source=new ArrayList<>(products);
        source.add(new Product("D", "book", 100, 1));
        Report result=report(source, 2);
        check(result.total==390&&result.counts.equals(Map.of("book", 2L, "tool", 1L))&&result.ids.equals(List.of("A", "D")), "STM-05 report");
        check(source.size()==4&&source.get(0)==products.get(0)&&source.get(0).stock==2, "STM-05 source");
        check(report(List.of(), 2).ids.isEmpty()&&report(source, 0).ids.isEmpty(), "STM-05 empty/limit");
        try {
            report(List.of(new Product("A", "x", 1, 1), new Product("A", "y", 2, 2)), 1);
            throw new AssertionError("STM-05 duplicate");
        }
        catch(IllegalArgumentException expected) {
        }
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS STM: 5 bài");
    }
}

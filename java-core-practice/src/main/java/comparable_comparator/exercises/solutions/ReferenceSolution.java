package comparable_comparator.exercises.solutions;

import java.util.*;

/** Một phương án tham khảo, chỉ mở sau khi tự làm. */
public class ReferenceSolution {
    private static void check(boolean condition, String message) {
        if (!condition) throw new AssertionError(message);
    }

    static final class Version implements Comparable<Version> {
        private final int major, minor;
        Version(int major, int minor) {
            if(major<0||minor<0)throw new IllegalArgumentException("version");
            this.major=major;
            this.minor=minor;
        }
        public int compareTo(Version v) {
            int c=Integer.compare(major, v.major);
            return c!=0?c:Integer.compare(minor, v.minor);
        }
        public boolean equals(Object o) {
            return o instanceof Version&&major==((Version)o).major&&minor==((Version)o).minor;
        }
        public int hashCode() {
            return 31*major+minor;
        }
        public String toString() {
            return major+"."+minor;
        }
    }
    static final class Runner {
        final String id;
        final int score;
        Runner(String id, int score) {
            if(id==null||id.trim().isEmpty()||score<0)throw new IllegalArgumentException("runner");
            this.id=id;
            this.score=score;
        }
        public boolean equals(Object o) {
            return o instanceof Runner&&id.equals(((Runner)o).id);
        }
        public int hashCode() {
            return id.hashCode();
        }
    }
    static final Comparator<Runner> SCORE_ASC=new Comparator<Runner>() {
        public int compare(Runner a, Runner b) {
            return Integer.compare(a.score, b.score);
        }
    };
    static final class Task {
        final String id;
        final int estimatedMinutes;
        Task(String id, int minutes) {
            if(id==null||id.trim().isEmpty()||minutes<0)throw new IllegalArgumentException("task");
            this.id=id;
            estimatedMinutes=minutes;
        }
    }
    static final Comparator<Task> BY_ID=new Comparator<Task>() {
        public int compare(Task a, Task b) {
            return a.id.compareTo(b.id);
        }
    };
    static final Comparator<Task> BY_TIME=new Comparator<Task>() {
        public int compare(Task a, Task b) {
            int c=Integer.compare(a.estimatedMinutes, b.estimatedMinutes);
            return c!=0?c:a.id.compareTo(b.id);
        }
    };
    static List<Runner> rank(List<Runner> source, int limit) {
        if(limit<0)throw new IllegalArgumentException("limit");
        Set<String> ids=new HashSet<>();
        for(Runner r:source)if(!ids.add(r.id))throw new IllegalArgumentException("duplicate id");
        List<Runner> copy=new ArrayList<>(source);
        copy.sort(new Comparator<Runner>() {
            public int compare(Runner a, Runner b) {
                int c=Integer.compare(b.score, a.score); return c!=0?c:a.id.compareTo(b.id);
            }
        });
        List<Runner> result=new ArrayList<>();
        for(int i=0; i<Math.min(limit, copy.size()); i++)result.add(copy.get(i));
        return result;
    }
    static void run() {
        List<Version> versions=new ArrayList<>(List.of(new Version(2, 0), new Version(1, 10), new Version(1, 2)));
        Collections.sort(versions);
        check(versions.toString().equals("[1.2, 1.10, 2.0]"), "CMP-01 natural order");
        List<Runner> ties=new ArrayList<>(List.of(new Runner("A", 10), new Runner("B", 10), new Runner("C", 5)));
        ties.sort(SCORE_ASC);
        check(ties.size()==3&&"C".equals(ties.get(0).id)&&"A".equals(ties.get(1).id)&&!ties.get(1).equals(ties.get(2)), "CMP-02 equal ordering");
        check(Integer.MIN_VALUE-1>0&&Integer.compare(Integer.MIN_VALUE, 1)<0&&Integer.compare(1, Integer.MIN_VALUE)>0&&Integer.compare(0, 0)==0, "CMP-03 overflow");
        check(Integer.compare(Integer.MIN_VALUE, 0)<0&&Integer.compare(0, Integer.MAX_VALUE)<0&&Integer.compare(Integer.MIN_VALUE, Integer.MAX_VALUE)<0, "CMP-03 transitive");
        List<Task> tasks=List.of(new Task("B", 20), new Task("A", 20), new Task("C", 5));
        List<Task> byId=new ArrayList<>(tasks), byTime=new ArrayList<>(tasks);
        byId.sort(BY_ID);
        byTime.sort(BY_TIME);
        check("A".equals(byId.get(0).id)&&"C".equals(byTime.get(0).id)&&"A".equals(byTime.get(1).id)&&"B".equals(tasks.get(0).id), "CMP-04 policies/source");
        List<Runner> runners=List.of(new Runner("B", 10), new Runner("A", 10), new Runner("C", 20));
        List<Runner> top=rank(runners, 2);
        check(top.size()==2&&"C".equals(top.get(0).id)&&"A".equals(top.get(1).id)&&"B".equals(runners.get(0).id), "CMP-05 rank");
        check(rank(runners, 0).isEmpty()&&rank(List.of(), 3).isEmpty(), "CMP-05 limits");
        try {
            rank(List.of(new Runner("A", 1), new Runner("A", 2)), 1);
            throw new AssertionError("CMP-05 duplicate");
        }
        catch(IllegalArgumentException expected) {
        }
    }

    public static void main(String[] args) throws Exception {
        run();
        System.out.println("PASS CMP: 5 bài");
    }
}

package exercises.mini_projects.student_management.exercises.solutions;

import java.util.*;

public class ReferenceSolution {
    private static void requireText(String s){if(s==null||s.isBlank())throw new IllegalArgumentException("Chuỗi rỗng");}
    private static void requireScore(double s){if(!Double.isFinite(s)||s<0||s>10)throw new IllegalArgumentException("Điểm sai");}
    public static boolean passed(double score){requireScore(score);return score>=5;}
    private static class Student {
        private final String id,name;
        private double score;
        Student(String id,String name,double score){requireText(id);requireText(name);requireScore(score);this.id=id;this.name=name.trim();this.score=score==0?0:score;}
    }
    public static class Snapshot {
        public final String id,name;
        public final double score;
        Snapshot(Student s){id=s.id;name=s.name;score=s.score;}
        public String toString(){return id+":"+score;}
    }
    public static class Service {
        private final Map<String,Student> students=new LinkedHashMap<>();
        public void add(String id,String name,double score){Student s=new Student(id,name,score);if(students.containsKey(id))throw new IllegalArgumentException("Trùng mã");students.put(id,s);}
        public double score(String id){Student s=students.get(id);if(s==null)throw new IllegalArgumentException("Không có mã");return s.score;}
        public void bulk(String[] ids,double[] scores){
            if(ids.length!=scores.length)throw new IllegalArgumentException("Khác độ dài");
            Set<String> seen=new HashSet<>();
            for(int i=0;i<ids.length;i++){requireText(ids[i]);if(!seen.add(ids[i])||!students.containsKey(ids[i]))throw new IllegalArgumentException("Mã sai");requireScore(scores[i]);}
            for(int i=0;i<ids.length;i++)students.get(ids[i]).score=scores[i]==0?0:scores[i];
        }
        public List<Snapshot> snapshot(){
            List<Snapshot> out=new ArrayList<>();
            for(Student s:students.values())out.add(new Snapshot(s));
            out.sort(new Comparator<Snapshot>() {
                @Override public int compare(Snapshot left,Snapshot right) {
                    int byScore=Double.compare(right.score,left.score);
                    return byScore!=0?byScore:left.id.compareTo(right.id);
                }
            });
            return out;
        }
        public String report(){if(students.isEmpty())return "EMPTY";double sum=0;int pass=0;for(Student s:students.values()){sum+=s.score;if(passed(s.score))pass++;}return "count="+students.size()+";passed="+pass+";average="+(sum/students.size());}
        public String command(String line){try{
            String[] p=line.split(";",-1);
            if(p.length==1&&p[0].equals("EXIT"))return "BYE";
            if(p.length==1&&p[0].equals("LIST"))return snapshot().toString();
            if(p.length==3&&p[0].equals("SCORE")){bulk(new String[]{p[1]},new double[]{Double.parseDouble(p[2])});return "OK";}
            return "ERR";
        }catch(IllegalArgumentException ex){return "ERR";}}
    }
    public static void console(Service service,Scanner input){while(input.hasNextLine()){String result=service.command(input.nextLine());System.out.println(result);if(result.equals("BYE"))break;}}

    private static void check(boolean ok) {
        if (!ok) throw new AssertionError("Sai kết quả");
    }
    private static void invalid(Runnable action) {
        try { action.run(); } catch (IllegalArgumentException expected) { return; }
        throw new AssertionError("Phải từ chối dữ liệu sai");
    }
    public static void main(String[] args) {
        check(!passed(4.9));check(passed(5));check(passed(10));invalid(()->passed(Double.NaN));invalid(()->passed(Double.POSITIVE_INFINITY));
        Service s=new Service();check(s.report().equals("EMPTY"));s.add("S1"," An ",6);s.add("S2","Binh",4);
        invalid(()->s.add("S1","Chi",8));check(s.report().equals("count=2;passed=1;average=5.0"));List<Snapshot> before=s.snapshot();
        s.bulk(new String[]{"S1","S2"},new double[]{8,10});check(s.report().equals("count=2;passed=2;average=9.0"));check(before.get(0).score==6);
        invalid(()->s.bulk(new String[]{"S1","S9"},new double[]{10,5}));check(s.score("S1")==8&&s.score("S2")==10);
        invalid(()->s.bulk(new String[]{"S1","S2"},new double[]{9,Double.NaN}));check(s.score("S1")==8);
        invalid(()->s.bulk(new String[]{"S1","S1"},new double[]{9,7}));invalid(()->s.bulk(new String[]{"S1"},new double[0]));
        s.bulk(new String[0],new double[0]);check(s.command("SCORE;S1;abc").equals("ERR"));check(s.command("SCORE;S1;").equals("ERR"));
        check(s.command("SCORE;S1;9").equals("OK"));check(s.command("LIST").contains("S1:9.0"));check(s.command("EXIT").equals("BYE"));
        s.bulk(new String[]{"S1","S2"},new double[]{8,8});check(s.snapshot().get(0).id.equals("S1"));
        List<Snapshot> external=s.snapshot();external.clear();check(s.snapshot().size()==2);
        Service zero=new Service();zero.add("B","B",0.0);zero.add("A","A",-0.0);
        check(zero.snapshot().get(0).id.equals("A"));
        zero.bulk(new String[]{"B","A"},new double[]{-0.0,0.0});check(zero.snapshot().get(0).id.equals("A"));
        console(s,new Scanner("SCORE;S1;abc\nLIST\nEXIT\n"));console(new Service(),new Scanner(""));
        System.out.println("OK exercises/mini_projects/student_management");
    }
}

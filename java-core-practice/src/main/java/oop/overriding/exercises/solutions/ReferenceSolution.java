package oop.overriding.exercises.solutions;
class Service {
    int fee(int units){return units<0||units>100?-1:10+units;}
    String describe(int n){return "fee="+fee(n);}
}
class PriorityService extends Service { @Override int fee(int units){int base=super.fee(units);return base<0?-1:base+5;} }
class PremiumService extends Service { @Override int fee(int units){int base=super.fee(units);return base<0?-1:base+10;} }
class BadService extends Service { @Override int fee(int units){return -5;} }
public class ReferenceSolution {
    static void check(boolean ok,String id){if(!ok)throw new AssertionError(id);}
    static int[] fees(Service[] ss,int n){if(ss==null)return new int[0];int[] out=new int[ss.length];for(int i=0;i<ss.length;i++)out[i]=ss[i]==null?-1:ss[i].fee(n);return out;}
    public static void main(String[] args){
        Service regular=new Service(),priority=new PriorityService(),premium=new PremiumService();
        check(regular.fee(3)==13&&priority.fee(3)==18&&priority.fee(-1)==-1&&priority.fee(101)==-1,"OVR-01");
        check(priority.describe(3).equals("fee=18")&&priority.describe(-1).equals("fee=-1"),"OVR-02");
        check(priority.fee(3)==18&&priority.fee(-1)==-1,"OVR-03");
        check(premium.fee(3)==23&&premium.fee(-1)==-1&&premium.fee(0)==20&&premium.fee(100)==120,"OVR-04");
        Service[] services={regular,priority,premium};int[] out=fees(services,3);int[] bad=fees(services,101);
        check(out[0]==13&&out[1]==18&&out[2]==23&&bad[0]==-1&&bad[1]==-1&&bad[2]==-1,"OVR-05");
        check(fees(null,0).length==0&&fees(new Service[0],0).length==0&&fees(new Service[]{null},0)[0]==-1,"OVR-05 empty");
        check(new BadService().fee(3)<-1,"OVR-05 demonstrate contract violation");
        System.out.println("PASS OVR-01..05; BadService chi de minh hoa vi pham hop dong");
    }
}

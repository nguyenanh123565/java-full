package enum_demo.exercises.solutions;
enum Direction {
    NORTH,EAST,SOUTH,WEST;
    Direction opposite(){return switch(this){case NORTH->SOUTH;case EAST->WEST;case SOUTH->NORTH;case WEST->EAST;};}
}
enum Channel {
    EMAIL("E"),SMS("S"),PUSH("P");
    private final String code;
    Channel(String code){this.code=code;} String code(){return code;}
    static Channel fromCode(String raw){if(raw==null)return null;String c=raw.trim();for(Channel ch:values())if(ch.code.equalsIgnoreCase(c))return ch;return null;}
}
enum ReorderedChannel {
    PUSH("P"),EMAIL("E"),SMS("S");
    private final String code;ReorderedChannel(String code){this.code=code;}String code(){return code;}
}
enum TicketState {
    OPEN,WORKING,RESOLVED,CLOSED;
    boolean canMoveTo(TicketState next){return switch(this){case OPEN->next==WORKING||next==CLOSED;case WORKING->next==RESOLVED;case RESOLVED->next==WORKING||next==CLOSED;case CLOSED->false;};}
}
class SupportTicket {
    private TicketState state=TicketState.OPEN;private Channel channel;
    SupportTicket(Channel channel){this.channel=channel==null?Channel.EMAIL:channel;}
    TicketState getState(){return state;}Channel getChannel(){return channel;}
    boolean moveTo(TicketState next){if(!state.canMoveTo(next))return false;state=next;return true;}
}
public class ReferenceSolution {
    static void check(boolean ok,String id){if(!ok)throw new AssertionError(id);}
    static int moveX(Direction d){if(d==null)return 0;return switch(d){case EAST->1;case WEST->-1;default->0;};}
    static int[] countByState(SupportTicket[] tickets){int[] out=new int[4];if(tickets!=null)for(SupportTicket t:tickets)if(t!=null)switch(t.getState()){case OPEN->out[0]++;case WORKING->out[1]++;case RESOLVED->out[2]++;case CLOSED->out[3]++;}return out;}
    public static void main(String[] args){
        for(Direction d:Direction.values())check(d.opposite().opposite()==d,"ENUM-01 roundtrip");check(moveX(Direction.WEST)==-1&&moveX(Direction.EAST)==1&&moveX(Direction.NORTH)==0&&moveX(null)==0,"ENUM-01");
        check(Channel.EMAIL.name().equals("EMAIL")&&Channel.EMAIL.ordinal()==0&&Channel.EMAIL.code().equals("E")&&ReorderedChannel.EMAIL.ordinal()==1&&ReorderedChannel.EMAIL.code().equals("E"),"ENUM-02");
        check(Channel.fromCode(" e ")==Channel.EMAIL&&Channel.fromCode("s")==Channel.SMS&&Channel.fromCode("P")==Channel.PUSH&&Channel.fromCode("SMS")==null&&Channel.fromCode(null)==null&&Channel.fromCode("")==null&&Channel.fromCode("X")==null,"ENUM-03");
        for(TicketState from:TicketState.values())for(TicketState to:TicketState.values()){
            boolean expected=from==TicketState.OPEN&&(to==TicketState.WORKING||to==TicketState.CLOSED)||from==TicketState.WORKING&&to==TicketState.RESOLVED||from==TicketState.RESOLVED&&(to==TicketState.WORKING||to==TicketState.CLOSED);
            check(from.canMoveTo(to)==expected,"ENUM-04 matrix "+from+"->"+to);
        }
        for(TicketState state:TicketState.values())check(!state.canMoveTo(null),"ENUM-04 null");
        SupportTicket flow=new SupportTicket(null);check(!flow.moveTo(TicketState.RESOLVED)&&flow.getState()==TicketState.OPEN&&flow.moveTo(TicketState.WORKING)&&flow.moveTo(TicketState.RESOLVED)&&flow.moveTo(TicketState.WORKING),"ENUM-04 flow");
        SupportTicket a=new SupportTicket(null),b=new SupportTicket(Channel.fromCode("s")),c=new SupportTicket(Channel.fromCode("P"));b.moveTo(TicketState.WORKING);c.moveTo(TicketState.CLOSED);
        int[] out=countByState(new SupportTicket[]{a,b,c,null});check(out[0]==1&&out[1]==1&&out[2]==0&&out[3]==1&&a.getChannel()==Channel.EMAIL&&!c.moveTo(TicketState.OPEN)&&!c.moveTo(null)&&c.getState()==TicketState.CLOSED,"ENUM-05");
        int[] empty=countByState(null);check(empty.length==4&&empty[0]+empty[1]+empty[2]+empty[3]==0&&countByState(new SupportTicket[0])[0]==0,"ENUM-05 empty");
        System.out.println("PASS ENUM-01..05 (du 16 cap trang thai)");
    }
}

package fundamental.memory.exercises.solutions;

import java.util.Arrays;
public class ReferenceSolution {
    public static int[] outer(int seed){int[] local={seed};return inner(local);}
    public static int[] inner(int[] values){values[0]++;return values;}
    public static int[][] independentRows(int count){
        int[][] out=new int[count][];for(int i=0;i<count;i++)out[i]=new int[]{i};return out;
    }
    public static class Slot { int[] data; Slot(int[] data){this.data=data;} }
    public static Slot makeSlot(){return new Slot(new int[]{7,8});}
    public static int[] nextVersion(int[] previous,int index,int value){
        int[] copy=Arrays.copyOf(previous,previous.length);copy[index]=value;return copy;
    }
    public static void main(String[] args){
        int seed=3;int[] result=outer(seed);assert seed==3&&result[0]==4;
        assert outer(0)[0]==1&&outer(-1)[0]==0;
        int[] row={1};int[][] table={row};row=null;table[0][0]=2;int[] saved=table[0];table=null;
        assert saved[0]==2;saved=null;
        // Không có assertion nào có thể chứng minh mảng đã bị GC ngay.
        int[][] out=independentRows(3);assert Arrays.deepEquals(out,new int[][]{{0},{1},{2}});
        out[0][0]=99;assert out[1][0]==1&&out[2][0]==2;
        assert independentRows(0).length==0&&independentRows(1)[0][0]==0;
        Slot slot=makeSlot();int[] retained=slot.data;slot=null;
        assert Arrays.equals(retained,new int[]{7,8});retained[0]=9;assert retained[0]==9;
        int[] v0={1,2};int[] v1=nextVersion(v0,0,9);int[] v2=nextVersion(v1,1,8);
        int[][] history={v0,v1,v2};assert Arrays.deepEquals(history,new int[][]{{1,2},{9,2},{9,8}});
        assert v0!=v1&&v1!=v2&&v0!=v2;
        v0=null;v1=null;assert history[0][0]==1&&history[1][0]==9;
        history[0]=null;history[1]=null;assert Arrays.equals(history[2],new int[]{9,8});
        int[] one={1};assert nextVersion(one,0,2)[0]==2&&one[0]==1;
        System.out.println("MEM: OK");
    }
}

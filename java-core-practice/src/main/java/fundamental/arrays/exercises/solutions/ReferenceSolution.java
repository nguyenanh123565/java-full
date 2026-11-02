package fundamental.arrays.exercises.solutions;

import java.util.Arrays;
public class ReferenceSolution {
    public static int countPositive(int[] values) { int count=0; for(int v:values) if(v>0)count++; return count; }
    public static void reset(int[] values) { for(int i=0;i<values.length;i++) values[i]=0; }
    public static int[] rotateRight(int[] values) {
        int[] result=new int[values.length];
        if(values.length>0) {
            result[0]=values[values.length-1];
            for(int i=0;i<values.length-1;i++)result[i+1]=values[i];
        }
        return result;
    }
    public static long[] rowTotals(int[][] matrix) {
        long[] totals=new long[matrix.length];
        for(int r=0;r<matrix.length;r++)for(int c=0;c<matrix[r].length;c++)totals[r]+=matrix[r][c];
        return totals;
    }
    public static long grandTotal(int[][] matrix) { long sum=0; for(long total:rowTotals(matrix))sum+=total; return sum; }
    public static void main(String[] args) {
        int[] values={-2,0,3,3}, copy=values.clone();
        assert countPositive(values)==2 && Arrays.equals(values,copy);
        assert countPositive(new int[0])==0 && countPositive(new int[]{Integer.MIN_VALUE,0,Integer.MAX_VALUE})==1;
        int[][] a={{1,2},{3}}, b=Arrays.copyOf(a,a.length);
        b[0][0]=9; b[1]=new int[]{8};
        assert Arrays.deepEquals(a,new int[][]{{9,2},{3}}) && Arrays.deepEquals(b,new int[][]{{9,2},{8}});
        assert a[0]==b[0] && a[1]!=b[1];
        b[0]=new int[0]; assert Arrays.equals(a[0],new int[]{9,2});
        int[] resetValues={4,-2}, alias=resetValues; reset(resetValues);
        assert alias==resetValues && Arrays.equals(alias,new int[]{0,0}); reset(new int[0]);
        int[] seed={1,2,3}, rotated=rotateRight(seed);
        assert Arrays.equals(rotated,new int[]{3,1,2}) && rotated!=seed;
        rotated[0]=99; assert Arrays.equals(seed,new int[]{1,2,3});
        int[] empty=new int[0]; assert rotateRight(empty)!=empty && rotateRight(empty).length==0;
        assert Arrays.equals(rotateRight(new int[]{7}),new int[]{7});
        assert Arrays.equals(rotateRight(new int[]{-1,-1,2}),new int[]{2,-1,-1});
        int[][] sales={{2,3},{},{4,0,5}};
        assert Arrays.equals(rowTotals(sales),new long[]{5,0,9}) && grandTotal(sales)==14;
        assert Arrays.deepEquals(sales,new int[][]{{2,3},{},{4,0,5}});
        assert grandTotal(new int[0][])==0 && grandTotal(new int[][]{{},{}})==0;
        int[][] large={new int[3000]}; Arrays.fill(large[0],1_000_000);
        assert grandTotal(large)==3_000_000_000L;
        System.out.println("ARR: OK");
    }
}

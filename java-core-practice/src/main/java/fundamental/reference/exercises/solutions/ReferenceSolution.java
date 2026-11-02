package fundamental.reference.exercises.solutions;

public class ReferenceSolution {
    public static class Box { public int value; public Box(int value){this.value=value;} }
    public static void resetValue(Box box){if(box!=null)box.value=0;}
    public static Box[] copyBoxes(Box[] source){
        Box[] result=new Box[source.length];
        for(int i=0;i<source.length;i++)if(source[i]!=null)result[i]=new Box(source[i].value);
        return result;
    }
    public static boolean transfer(Box from,Box to,int amount){
        if(from==null||to==null||from.value<amount)return false;
        if(from==to)return true;
        from.value-=amount;to.value+=amount;return true;
    }
    public static void main(String[] args){
        Box a=new Box(5),alias=a;int saved=a.value;alias.value=8;
        assert a.value==8&&saved==5&&a==alias;
        alias=new Box(9);assert a.value==8&&saved==5;
        Box shared=new Box(1);Box[] boxes={shared,shared};boxes[0].value=7;boxes[0]=new Box(9);
        assert boxes[0].value==9&&boxes[1].value==7&&shared.value==7&&boxes[0]!=boxes[1];
        shared=null;assert boxes[1].value==7;
        a=new Box(9);alias=a;resetValue(a);assert a.value==0&&alias.value==0&&a==alias;resetValue(null);
        shared=new Box(4);Box[] source={shared,shared,null};Box[] copy=copyBoxes(source);copy[0].value=99;
        assert source[0].value==4&&copy[1].value==4&&copy[2]==null&&copy!=source&&copy[0]!=source[0]&&copy[0]!=copy[1];
        assert copyBoxes(new Box[0]).length==0&&copyBoxes(new Box[]{null})[0]==null;
        assert copyBoxes(new Box[]{new Box(-1)})[0].value==-1;
        Box from=new Box(10),to=new Box(3);
        assert transfer(from,to,4)&&from.value==6&&to.value==7;
        assert !transfer(from,to,20)&&from.value==6&&to.value==7;
        assert transfer(from,from,4)&&from.value==6;
        assert !transfer(from,from,7)&&from.value==6;
        assert !transfer(null,to,1)&&!transfer(from,null,1)&&from.value==6&&to.value==7;
        assert transfer(from,to,0)&&from.value==6&&to.value==7;
        assert transfer(from,to,6)&&from.value==0&&to.value==13;
        System.out.println("REF: OK");
    }
}

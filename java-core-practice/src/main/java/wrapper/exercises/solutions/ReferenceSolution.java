package wrapper.exercises.solutions;

public class ReferenceSolution {
    public static Integer choose(Integer preferred,Integer fallback){if(preferred!=null)return preferred;return fallback;}
    public static Integer importNumber(String text){
        if(text==null)return null;String clean=text.trim();if(clean.length()==0)return null;
        try{return Integer.valueOf(clean);}catch(NumberFormatException e){return null;}
    }
    public static String sensorReport(Integer[] readings){
        int count=0,missing=0,min=0,max=0;long sum=0;
        for(Integer boxed:readings){
            if(boxed==null){missing++;continue;}int value=boxed;
            if(count==0){min=value;max=value;}else{if(value<min)min=value;if(value>max)max=value;}
            count++;sum+=value;
        }
        String minText=count==0?"NA":""+min,maxText=count==0?"NA":""+max;
        return "count="+count+";missing="+missing+";sum="+sum+";min="+minText+";max="+maxText;
    }
    public static Integer[] importReadings(String[] input){
        Integer[] out=new Integer[input.length];for(int i=0;i<input.length;i++)out[i]=importNumber(input[i]);return out;
    }
    public static void main(String[] args){
        String[] inputs={"12","+12","-7","2147483647","2147483648",""," 12 ","-2147483648"};
        int valid=0,errors=0;
        for(String text:inputs){try{int primitive=Integer.parseInt(text);Integer boxed=Integer.valueOf(text);assert primitive==boxed.intValue();valid++;}catch(NumberFormatException e){errors++;}}
        assert valid==5&&errors==3;
        Integer a=1000,b=1000;Long c=1000L;
        System.out.println("1000 identity (quan sat JVM): "+(a==b));
        assert a.equals(b)&&!a.equals(c)&&a.intValue()==c.longValue();
        Integer smallA=127,smallB=127;assert smallA==smallB;
        assert choose(8,3).equals(8)&&choose(null,3).equals(3)&&choose(8,null).equals(8);
        assert choose(null,null)==null&&choose(0,5).equals(0)&&choose(-1,5).equals(-1);
        String[] raw={" 8 ","abc",null,"0","-3",""};int count=0;long sum=0;
        for(String text:raw){Integer value=importNumber(text);if(value!=null){count++;sum+=value;}}
        assert count==3&&sum==5&&importNumber("0")!=null;
        assert importNumber("-2147483648").equals(Integer.MIN_VALUE)&&importNumber("2147483647").equals(Integer.MAX_VALUE);
        assert importNumber("2147483648")==null&&importNumber("-2147483649")==null;
        Integer[] readings={0,null,-5,20};
        assert sensorReport(readings).equals("count=3;missing=1;sum=15;min=-5;max=20")&&readings[1]==null;
        assert sensorReport(new Integer[]{null,null}).equals("count=0;missing=2;sum=0;min=NA;max=NA");
        assert sensorReport(new Integer[0]).equals("count=0;missing=0;sum=0;min=NA;max=NA");
        assert sensorReport(new Integer[]{-9,-2}).equals("count=2;missing=0;sum=-11;min=-9;max=-2");
        assert sensorReport(new Integer[]{0}).equals("count=1;missing=0;sum=0;min=0;max=0");
        assert sensorReport(new Integer[]{Integer.MAX_VALUE,Integer.MAX_VALUE}).equals("count=2;missing=0;sum=4294967294;min=2147483647;max=2147483647");
        assert sensorReport(importReadings(new String[]{"0",null,"abc","-5","20"})).equals("count=3;missing=2;sum=15;min=-5;max=20");
        System.out.println("WRP: OK");
    }
}

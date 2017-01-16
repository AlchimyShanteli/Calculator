public class Calc {
    static String a;
    public static String count(String d1, int m){
        if(!d1.equals("0")){
            a = d1;
            a += Integer.toString(m);
        }else {
            a = d1;
            a = Integer.toString(m);
        }
        return a;
    }
}

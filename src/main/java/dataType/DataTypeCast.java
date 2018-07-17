package dataType;

public class DataTypeCast {
    public static void main(String[] args){
        byte a = 127;
        byte b = 127;

        b += a;
        System.out.println(b);

        System.out.println(3*0.1==3);


        for (int i = 0; i < 1000; i++) {
            a++;
            System.out.println(a + ": " + Byte.toString(a));
        }
    }
}

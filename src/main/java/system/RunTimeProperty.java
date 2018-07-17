package system;

public class RunTimeProperty {
    public static void main(String[] args){

        long l = Runtime.getRuntime().freeMemory();
        long l1 = Runtime.getRuntime().totalMemory();

        System.out.println(l / (1000 * 1000 * 8));
    }
}

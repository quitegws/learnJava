import java.io.FileNotFoundException;
import java.util.LinkedHashMap;

/**
 * @Author: gws
 * @Date: 17/07/2018 21:00
 * @Description:
 */
public class TryCatchReturn {
    public static void main(String[] args) throws FileNotFoundException {
        TryCatchReturn m = new TryCatchReturn();
//        PrintStream st = new PrintStream(new FileOutputStream("output.txt"));
//
//        System.setErr(st);
//        System.setOut(st);
//        System.out.println(m.getNumber());

        char c = '你';
        System.out.println(c);

        LinkedHashMap<Integer, String> treeMap = new LinkedHashMap();
        treeMap.put(2,"2");
        treeMap.put(4,"4");
        treeMap.put(1,"1");
        treeMap.put(-1,"1");
        treeMap.put(3,"3");
        treeMap.put(0,"3");


        for (Integer i : treeMap.keySet()) {
            System.out.println(i + " : " + treeMap.get(i));
        }
    }

    public int getNumber() {

        int a = 0;

        try {
            String s = "t"; //------------------------（1）
            a = Integer.parseInt(s);//-----------（2）
            return a;
        } catch (NumberFormatException e) {
            a = 1;//-----------------------------------（3）
            return a;//-------------------------------（4）
        } finally {
            a = 2;//-----------------------------------（5）
            return a;
        }
    }
}

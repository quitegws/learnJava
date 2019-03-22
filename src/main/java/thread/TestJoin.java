package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: gws
 * @Date: 12/08/2018 15:25
 * @Description:
 */
public class TestJoin {
    static long fabic(int n) {
        if(n < 0) {
            throw new NumberFormatException("不能小于0");
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        return fabic(n - 1) + fabic(n - 2);
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int NUM = 3;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < NUM; i++) {
            list.add(i);
        }
        for(Integer i  : list) {
            //  创建线程
            Thread th = new Thread(() ->
                fabic(35 + i)
            );
            th.start();
            th.join();
        }
        //  打印花费的时间
        System.out.println(System.currentTimeMillis() - startTime);
    }
}

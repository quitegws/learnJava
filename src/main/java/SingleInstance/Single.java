package SingleInstance;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: gws
 * @Date: 04/10/2018 20:08
 * @Description:
 */
public class Single {
    private static volatile Single instance;
    private Single(){}

    public static Single getInstance(){
        if(instance == null){
            synchronized (Single.class) {
                if(instance == null){
                    instance = new Single();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toString(Single.COUNT_BITS, 2));
        System.out.println(Integer.toString(Single.CAPACITY, 2));
        System.out.println(Integer.toString(Single.RUNNING, 2));
        System.out.println(Integer.toString(Single.SHUTDOWN, 2));
        System.out.println(Integer.toString(Single.STOP, 2));
        System.out.println(Integer.toString(Single.TIDYING, 2));
        System.out.println(Integer.toString(Single.TERMINATED, 2));


    }
    final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    static final int COUNT_BITS = Integer.SIZE - 3;
    static final int CAPACITY   = (1 << COUNT_BITS) - 1;


    static final int RUNNING    = -1 << COUNT_BITS;
    static final int SHUTDOWN   =  0 << COUNT_BITS;
    static final int STOP       =  1 << COUNT_BITS;
    static final int TIDYING    =  2 << COUNT_BITS;
    static final int TERMINATED =  3 << COUNT_BITS;


    static int runStateOf(int c)     { return c & ~CAPACITY; }
    static int workerCountOf(int c)  { return c & CAPACITY; }
    static int ctlOf(int rs, int wc) { return rs | wc; }
}

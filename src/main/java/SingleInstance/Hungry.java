package SingleInstance;

/**
 * @Author: gws
 * @Date: 04/10/2018 20:14
 * @Description:
 */
public class Hungry {
    private static class InstanceHolder{
        private static Hungry instance = new Hungry();
    }
    private Hungry(){}
    public static final Hungry getInstance(){
        return InstanceHolder.instance;
    }
}

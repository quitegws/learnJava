package thread;

/**
 * @Author: gws
 * @Date: 12/08/2018 13:54
 * @Description:
 */
public class JoinBetweenTwoThread {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1("t1");

        t1.start();

        while(t1.isAlive()){
            t1.join();
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.sleep(1000);
        }

    }

}

class T1 extends Thread{
    public T1(String name){
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while(i < 10){
            String name = Thread.currentThread().getName();
            System.out.println(name + " is running");
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
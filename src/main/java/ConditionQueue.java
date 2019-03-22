import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: gws
 * @Date: 2019-03-17 16:00
 * @Description:
 */
public class ConditionQueue<T> {

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private  Object[] elements;

    private int count = 0;
    private int putIndex = 0;
    private int getIndex = 0;

    public ConditionQueue(int size){
        if(size <= 0) throw new IllegalArgumentException();
        elements = new Object[size];
    }

    public void put(T element) throws InterruptedException {
        lock.lock();
        try{
            while(count == elements.length){
                System.out.println("ConditionQueue is full, waiting for element to be removed ..");
                notFull.await();
            }
            elements[putIndex] = element;
            count++;
            if(++putIndex == elements.length) {
                putIndex = 0;
            }
            System.out.println(Thread.currentThread()+" 插入一个元素，数组为："+Arrays.toString(elements));

            notEmpty.signal();

        }finally {
            lock.unlock();
        }

    }

    public T get() throws InterruptedException {
        lock.lock();

        try{
            while(count == 0){
                System.out.println("ConditionQueue is empty, waiting for element to be added ....");
                notEmpty.await();
            }

            T r = (T) elements[getIndex];
            elements[getIndex] = null;
            count--;
            if (++getIndex == elements.length) {
                getIndex = 0;
            }
            System.out.println(Thread.currentThread()+" 得到一个元素，数组为："+Arrays.toString(elements));

            notFull.signal();
            return r;

        }finally {
            lock.unlock();
        }
    }

    private static final Random random = new Random(System.currentTimeMillis());


    public static void main(String[] args) {
        ConditionQueue<Integer> queue = new ConditionQueue<>(10);
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.put(new Integer(random.nextInt(100)));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },String.valueOf(i)).start();

        }
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        queue.get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },String.valueOf(i)).start();
        }
    }

    @Override
    public String toString() {
        return "ConditionQueue{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}

package thread;

import java.util.Vector;

public class ProducerAndConsumer {
    public static void main(String[] args){
        int size = 100;
        Vector vector = new Vector(size);
        Producer producer = new Producer(vector,size);
        Consumer consumer = new Consumer(vector,size);

        new Thread(consumer).start();
        new Thread(producer).start();
    }
}

class Consumer implements Runnable{

    public Vector vector;
    public int size;

    public Consumer(Vector vector, int size){
        this.vector = vector;
        this.size = size;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("consume : " + consume());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int consume() throws InterruptedException {
        while(vector.isEmpty()){
            synchronized (vector){
                System.out.println("Queue is empty " + Thread.currentThread().getName()

                        + " is waiting , size: " + vector.size());
                vector.wait();
            }
        }

        synchronized (vector){
            vector.notifyAll();
            return (Integer) vector.remove(0);
        }

    }
}

class Producer implements Runnable{

    public Vector vector;
    public int size;

    public Producer(Vector vector, int size){
        this.vector = vector;
        this.size = size;

    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            try {
                produce(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        while (vector.size() == size) {
            synchronized (vector){
                System.out.println("Queue is full " + Thread.currentThread().getName()

                        + " is waiting , size: " + vector.size());
                vector.wait();
            }
        }

        synchronized (vector){
            vector.add(i);
            vector.notifyAll();
        }
    }


}

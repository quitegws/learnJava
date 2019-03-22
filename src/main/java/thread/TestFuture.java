package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: gws
 * @Date: 12/08/2018 18:54
 * @Description:
 */
public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> submit = es.submit(new Task());
            list.add(submit);
        }

        for(Future<String> f : list){
            System.out.println(f.get());
        }
    }

    public static class Task implements Callable<String>{

        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName();
        }
    }
}

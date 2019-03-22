import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: gws
 * @Date: 2019-03-16 20:40
 * @Description:
 */
public class TestPriorityQueue {


    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        queue.offer(0);
        queue.offer(1);
        queue.offer(-1);
        queue.offer(-9);
        queue.offer(21);
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);

    }
}

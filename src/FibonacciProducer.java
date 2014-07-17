import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FibonacciProducer implements Callable<Integer> {

    FibonacciGenerator fbg;
    private Integer result = 0;
    Queue<Integer> queue;
    Integer limit;
    

    public FibonacciProducer(FibonacciGenerator fbg, ConcurrentLinkedQueue<Integer> queue, Integer limit) {
        this.fbg = fbg;
        this.queue = queue;
        this.limit = limit;
        
    }

    public Integer call() {
//        result = fbg.generate();
//        queue.add(result);
//        System.out.println("i am from 1st thread Fibonacci :" + result);
//        if (Thread.currentThread().isInterrupted()) {
//            // Cannot use InterruptedException since it's checked
//            throw new RuntimeException();
//        }
//        return result;
        
        while (result <limit){
            result = fbg.generate();
            queue.add(result);
        }
        return null;
    }

    public Integer getResult() {
        return result;
    }
}

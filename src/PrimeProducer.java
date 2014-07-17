import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PrimeProducer implements Callable<Integer> {
    // implements Runnable{

    PrimeGenerator pg;
    Integer result = 0;
    Queue<Integer> queue;
    Integer limit;

    public PrimeProducer(PrimeGenerator pg, ConcurrentLinkedQueue<Integer> queue, Integer limit) {
        this.pg = pg;
        this.queue = queue;
        this.limit = limit;
    }

    public Integer call() {
//        result = pg.generate();
//        System.out.println("i am from 2nd thread Prime :" + result);
//        queue.add(result);
//        if (Thread.currentThread().isInterrupted()) {
//            // Cannot use InterruptedException since it's checked
//            throw new RuntimeException();
//        }
//        return result;
        while (result <limit){
            result = pg.generate();
            queue.add(result);
        }
            
        return null;
    }

    public Integer getResult() {
        return result;
    }
}

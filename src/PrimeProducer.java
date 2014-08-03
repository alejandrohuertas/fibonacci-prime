import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PrimeProducer implements Callable<Integer> {

    PrimeGenerator pg;
    Integer result = 0;
    Queue<Integer> queue;
    Integer limit;

    public PrimeProducer(PrimeGenerator pg, ConcurrentLinkedQueue<Integer> queue, Integer limit) {
        this.pg = pg;
        this.queue = queue;
        this.limit = limit;
    }
    @Override
    public Integer call() {

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

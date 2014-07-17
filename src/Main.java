import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queuePrime = new ConcurrentLinkedQueue<Integer>();
        ConcurrentLinkedQueue<Integer> queueFibo = new ConcurrentLinkedQueue<Integer>();
        Integer limit = 10000;
        
        PrimeProducer primeProducer = new PrimeProducer(new PrimeGenerator(),queuePrime,limit);
        FibonacciProducer fiboProducer = new FibonacciProducer(new FibonacciGenerator(),queueFibo,limit);
        
        ExampleConsumer consumer = new ExampleConsumer(queueFibo, queuePrime);
        
        ExecutorService exService = Executors.newFixedThreadPool(2);
        exService.submit(primeProducer);
        exService.submit(fiboProducer);
        new Thread(consumer).start();
    }
}

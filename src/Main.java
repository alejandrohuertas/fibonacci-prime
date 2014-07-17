import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) {
        //Defino las colas para las sequencias de numeros
        ConcurrentLinkedQueue<Integer> queuePrime = new ConcurrentLinkedQueue<Integer>();
        ConcurrentLinkedQueue<Integer> queueFibo = new ConcurrentLinkedQueue<Integer>();
        Integer limit = 100000;
        
        //Defino los productores de la secuencia y le asigno sus respectivas colas para que los almacenen
        PrimeProducer primeProducer = new PrimeProducer(new PrimeGenerator(),queuePrime,limit);
        FibonacciProducer fiboProducer = new FibonacciProducer(new FibonacciGenerator(),queueFibo,limit);
        
        ExampleConsumer consumer = new ExampleConsumer(queueFibo, queuePrime);
        
        ExecutorService exService = Executors.newFixedThreadPool(2);
        exService.submit(primeProducer);
        exService.submit(fiboProducer);
        exService.shutdown();

        //Espero a que termine las producciones de las 2 sequencias hasta el limite dado
        while (!exService.isTerminated()){
            
        }
        //Con el consumidor analizo cuales son los numeros Fibonacci Primos
        exService = Executors.newSingleThreadExecutor();
        exService.submit(consumer);
        exService.shutdown();

    }
}

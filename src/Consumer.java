import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;


public class Consumer implements Callable<Integer> {

    
    Queue<Integer> queueFibo;
    Queue<Integer> queuePrime;
    
    Consumer(ConcurrentLinkedQueue<Integer> queueFibo,ConcurrentLinkedQueue<Integer> queuePrime ){
       this.queueFibo = queueFibo;
       this.queuePrime = queuePrime;
    }
    @Override
    public Integer call() {
        System.out.println("Consumer iniciado");
        Integer prime;
        prime = queuePrime.poll();
        while ( prime !=null ){
//            System.out.println("extrae de primos "+ prime);
            prime = queuePrime.poll();
            if (queueFibo.contains(prime)){
                System.out.println("Este personaje se encuentra en las dos sequencias --> "+prime);
            }
        }
//        while (( fibo =queueFibo.poll())!=null ){
//            System.out.println("extrae de fibonacci "+fibo);
//        }
        System.out.println("Consumer finalizado");
        return null;
    }

}

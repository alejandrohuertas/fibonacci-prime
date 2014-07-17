import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


public class ExampleConsumer implements Runnable {

    
    Queue<Integer> queueFibo;
    Queue<Integer> queuePrime;
    
    ExampleConsumer(ConcurrentLinkedQueue<Integer> queueFibo,ConcurrentLinkedQueue<Integer> queuePrime ){
       this.queueFibo = queueFibo;
       this.queuePrime = queuePrime;
    }
    @Override
    public void run() {
        System.out.println("ExampleConsumer iniciado");
        Integer prime, fibo;
        while (( prime =queuePrime.poll())!=null ){
            System.out.println("extrae de primos "+ prime);
        }
        while (( fibo =queueFibo.poll())!=null ){
            System.out.println("extrae de fibonacci "+fibo);
        }
//        TODO: analisis de si son estan el los dos imprimir
        System.out.println("Aca va el analisis de si estan en las dos colas");
    }

}

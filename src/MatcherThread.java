import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatcherThread {

    public static void main(String[] args) {

        Integer limit = 100000;
        PrimeProducer primeThread = new PrimeProducer(new PrimeGenerator(), null,null);

        FibonacciProducer fibonacciThread = new FibonacciProducer(new FibonacciGenerator(), null,null);

      
        ExecutorService exService = Executors.newFixedThreadPool(2);

        Future<Integer> futureFib = exService.submit(fibonacciThread);
        Future<Integer> futurePri = exService.submit(primeThread);
        try {
            while (futureFib.get()<=limit || futurePri.get()<=limit){
                if (futureFib.get()>limit){
//                    System.out.println("los fibonacci superaron el limite!!!!!!! "+ limit);
                    futureFib.cancel(true);
                    futurePri = exService.submit(primeThread);
                    
                } else if (futurePri.get()>limit){
//                    System.out.println("los primos superaron el limite!!!!!!! "+ limit);
                    futurePri.cancel(true);
                    futureFib = exService.submit(fibonacciThread);
                    
                } else{
                
                    futureFib = exService.submit(fibonacciThread); 
                    futurePri = exService.submit(primeThread);
                }
            }
            exService.shutdown();
            System.out.println("Ejecucion terminada");
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
//        }
        
//        while (!exService.isTerminated()){
//            
//        }
        // exService.submit(fibonacciThread);
        // exService.submit(primeThread);

//        Collection<Callable<Integer>> callables = new ArrayList<Callable<Integer>>();
//
//        callables.add(primeThread);
//        callables.add(fibonacciThread);
//        try {
//            List<Future<Integer>> futures = exService.invokeAll(callables);
//            System.out.println(futures.get(0).get());
//            System.out.println(futures.get(1).get());
//            while (futures.get(0).get() <= limit || futures.get(1).get() <= limit) {
//                    if (futures.get(0).get()>limit){
//                        System.out.println("los primos superaron el limite!!!!!!! "+ limit);
//                        futures.get(0).cancel(true);
//                        exService.shutdown();
//                    }
//                    if (futures.get(1).get()>limit){
//                        System.out.println("los fibonacci superaron el limite!!!!!!! "+ limit);
//                        futures.get(1).cancel(true);
//                        exService.shutdown();
//                    }
//                    futures = exService.invokeAll(callables);
//                
//                System.out.println(futures.get(0).get());
//                System.out.println(futures.get(1).get());
            }
//          exService.shutdown();
//          System.out.println("Ejecucion terminada");
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

    }

}

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MatcherThread {

    public static void main (String []args){
    	
    	PrimeThread primeThread = new PrimeThread(new PrimeGenerator());
    	
    	FibonacciThread fibonacciThread = new FibonacciThread(new FibonacciGenerator());
    	Integer limit = 100000;
    	
    	
//    	while (fibonacciThread.getResult() <= limit){
//    		fibonacciThread.call();
//    	}
//    	while (primeThread.getResult()<=limit){
//    		primeThread.run();
//    	}
    	
    	ExecutorService exService = Executors.newFixedThreadPool(2);
    	
//    	exService.submit(fibonacciThread);
//    	exService.submit(primeThread);
    	
    	Collection<Callable<Integer>> callables = new ArrayList<Callable<Integer>>();
    	
    	callables.add(primeThread);
    	callables.add(fibonacciThread);
    	try {
    		List<Future<Integer>> futures= exService.invokeAll(callables);
    		System.out.println(futures.get(0).get());
    		System.out.println(futures.get(1).get());
    		while (futures.get(0).get() <limit || futures.get(1).get() <limit){
    			futures= exService.invokeAll(callables);
    			System.out.println(futures.get(0).get());
        		System.out.println(futures.get(1).get());
    		}
			System.out.println("litto");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    }

	
}

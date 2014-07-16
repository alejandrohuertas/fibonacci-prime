
public class MatcherThread {

    public static void main (String []args){
    	
    	PrimeThread primeThread = new PrimeThread(new PrimeGenerator());
    	
    	FibonacciThread fibonacciThread = new FibonacciThread(new FibonacciGenerator());
    	Integer limit = 1000;
    	
    	
    	while (fibonacciThread.getResult() <= limit){
    		fibonacciThread.run();
    	}
    	while (primeThread.getResult()<=limit){
    		primeThread.run();
    	}
    }
}

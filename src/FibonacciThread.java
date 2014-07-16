import java.util.concurrent.Callable;


public class FibonacciThread implements Callable<Integer>{

	FibonacciGenerator fbg;
	
	private Integer result =0;
	
	public FibonacciThread(FibonacciGenerator fbg){
		this.fbg = fbg;
	}
	
	public Integer call(){
		result = fbg.generate();
		
		//System.out.println("i am from 1st thread Fibonacci :"+result);
		return result;
	}

	public Integer getResult() {
		return result;
	}
}

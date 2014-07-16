
public class FibonacciThread implements Runnable{

	FibonacciGenerator fbg;
	
	private Integer result =0;
	
	public FibonacciThread(FibonacciGenerator fbg){
		this.fbg = fbg;
	}
	
	public void run(){
		result = fbg.generate();
		
		System.out.println("i am from 1st thread Fibonacci :"+result);
	}

	public Integer getResult() {
		return result;
	}
}

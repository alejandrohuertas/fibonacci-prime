import java.util.concurrent.Callable;

public class PrimeThread 
	implements Callable<Integer>{
//	implements Runnable{

	PrimeGenerator pg;
	Integer result = 0;
	
	
	public PrimeThread(PrimeGenerator pg){
		this.pg = pg;
	}
	
	public Integer call(){
		result = pg.generate();
//		 System.out.println("i am from 2nd thread Prime :"+result);
		 return result;
	}
	
	public Integer getResult(){
		return result;
	}
}

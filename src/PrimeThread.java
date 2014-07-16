
public class PrimeThread implements Runnable{

	PrimeGenerator pg;
	Integer result = 0;
	
	
	public PrimeThread(PrimeGenerator pg){
		this.pg = pg;
	}
	
	public void run(){
		result = pg.generate();
		 System.out.println("i am from 2nd thread Prime :"+result);
	}
	
	public Integer getResult(){
		return result;
	}
}

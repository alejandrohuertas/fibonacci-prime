
public class FibonacciGenerator {

    private Integer limit;
    static private Integer fibo;
    private Integer fiboPrev;
    private boolean first;
    private boolean second;
    
    public FibonacciGenerator(Integer top){
    	limit = top;
    	fibo = fiboPrev = 1;
    	first = true;
    	second = true;
    }
    
    public FibonacciGenerator(){
    	this(null);
    }

    public Integer getLimit() {
	return limit;
    }

    public void setLimit(Integer limit) {
	this.limit = limit;
    }
    
    synchronized public Integer generate(){
	if (first){
	    first = false;
	    return  fibo;
	}
	if (fibo == fiboPrev && second){
	    second = false;
	    return fibo;
	}
	    Integer temp = fibo;
	    fibo = fibo+fiboPrev;
	    fiboPrev = temp;
	
	return fibo;
		
    }
    
//    public static void main (String []args){
//	
//	FibonacciGenerator fg = new FibonacciGenerator(100000);
//	Integer result =fg.generate();
//	
//		while (result < fg.getLimit()){
//		    System.out.println("va "+ result);
//		    result = fg.generate();
//		}
//    }
}

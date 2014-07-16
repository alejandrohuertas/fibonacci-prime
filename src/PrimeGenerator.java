
public class PrimeGenerator {

    private Integer limit;
    private Integer start;
    private boolean first;
    static Integer prime;
    
    public PrimeGenerator(Integer top){
		limit = top;
		start = 1;
		first = true;
    }

    public PrimeGenerator() {
		this(null);
	}

	public Integer getLimit() {
	return limit;
    }

    public void setLimit(Integer limit) {
	this.limit = limit;
    }
    
    synchronized public Integer generate(){
		prime= start;
		if (first){
		    first = false;
		    start++;
		    return prime;
		    
		}
		int divisores = 0;
		for (int i= 1; i<=start;i++){
		    if (start % i == 0){
			divisores++;
		    }
		}
		if (divisores == 2){
		    prime = start;
		    start++;
		    return prime;
		}
		start++;
		return generate();
    }
    
//    public static void main (String []args){
//	
//		PrimeGenerator fg = new PrimeGenerator(100000);
//		Integer result =fg.generate();
//		
//		while (result < fg.getLimit()){
//		    System.out.println("va "+ result);
//		    result = fg.generate();
//		}
//    }
}

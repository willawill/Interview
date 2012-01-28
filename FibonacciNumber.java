public class FibonacciNumber{
	private static final int max = 1000;
	private long[] fib;

	public FibonacciNumber(){
		fib = new long[max];
	}
	
	public long fib(long i){
		if (i == 0) return 0;
		if (i == 1) return 1;
		if (fib[i] != 0) return fib[i];
		fib[i] = fib(i-1) + fib(i-2);
		System.out.println(fib[i]);
		return fib[i];
	}
	public long fib2(long i){
		if (i == 0 ) return 0;
		if (i == 1 ) return 1;
		return fib2(i-1)+fib2(i-2);
	}

	public static void main(String[] args){
		FibonacciNumber fn = new FibonacciNumber();
		System.out.println(fn.fib(1000));


	}
}
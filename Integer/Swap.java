public class Swap{
	public static void swap(int x, int y){
		x = x ^ y;
		y = x ^ y;
		x = x ^ y;
		System.out.println(x + " is now " + y);
	}
	public static void swap2(int a, int b){
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(a + " is now " + b);
	
	}
	public static void main(String[] args){
		Swap.swap(2,3);
		Swap.swap2(3,4);
	}
}
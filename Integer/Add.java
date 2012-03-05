public class Add{
	
	public static int add(int a, int b){
			if (a==0) return b;
			if (b==0) return a;
			//Add without carry, ith would be 0 if both a,b are 1 or 0.That's XOR
			int sum = a^b;
			//ith bit will be 1 only if a and b at (i-1)th are both 1. That's AND
			int carry = (a & b);
			while ((a&b)>0){
				a = a^b;
				b = carry<<1;

			}
			return (a^b);
	}
	//Add recursively
	public static int addR(int a, int b){
		if (b==0) return a;
		int sum = a ^b;
		int carry = (a&b) <<1;
		return addR(sum, carry);
	}
	public static void main(String[] args){
		System.out.println(addR(2,13));
	}
}
public class count1{
	
	public static void count1(int num){
		int x = num;
		if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) System.out.print("Invalid input");
		else{
			x = Math.abs(x);
			int count = 0;
			while (x>0){
				x &= x-1;//Indicate if x-1 bit is power of 2, which means there is 1.
				count++;
			}
		System.out.println("The number " + num + " has "+ count + " 1s.");
		}	
	}

	public static void main(String[] args){
		count1.count1(15);
		count1.count1(-15);
		count1.count1(0);
		count1.count1(Integer.MAX_VALUE);
		count1.count1(Integer.MIN_VALUE);
	}

}
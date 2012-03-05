public class Find2Odd{
	public static void find2odd(int[] input){
		int s = 0;
		for (int i:input){
			s ^= i;//s=a^b
		}
		int disc = s & ~(s-1);
		int a, b;
		a=0;b=0;
		for (int j:input){
			if ((j & disc) > 0){
				a ^= j;//bits set to a in s
			}
			else{
				b ^=j;//bits set to b in s
			}
		}
			System.out.println(a);
			System.out.println(b);

		}


	public static void main(String[] args){
		int[] input = {1,1,2,2,3,4,5,5,6,6,6,6};
		Find2Odd.find2odd(input);
	}

}
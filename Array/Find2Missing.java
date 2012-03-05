import java.util.*;
public class Find2Missing{
	public static void find2missing(int[] input, int N){
		//The same with find 2 odd. Merge two arrays.
		int[] inputList = new int[N+input.length];
		for (int i = 0; i < input.length; i++){
			inputList[i] = input[i];
		}	
		for (int i = input.length;N!=0;i++){
			inputList[i] = N;
			N--;
		}
		int s=0;
		for(int i: inputList){
			s ^= i;
		}
		//S= a^b;Seperate bits in a and b.
//Get the rightmost set bit in disc
		int disc = s & ~(s-1);
		int a = 0; int b = 0;
		for (int i:inputList){
			if ((i & disc)>0){
				a^=i;
				//System.out.println(a);
			}
			else b^=i;
		}
		System.out.println(a);
		System.out.println(b);
		
	}
	public static void main(String[] args){
		int[] input= {1,2,4,8,6,5,7,10,13,9,11,14,12,18,16,17,15};
		Find2Missing.find2missing(input, 19);
	}
}
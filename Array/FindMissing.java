public class FindMissing{
	public static int findMissing(int[] input, int N){
		if (input.length == 0) return -1;
		int template = 0;
		while (N!=0){
			template ^=N;
			N--;
		}
		for (int i : input){
			template ^= i;
		}
		return template;

	}

	public static void main(String[] args){
		int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		System.out.println(FindMissing.findMissing(input, 14));

	}
}
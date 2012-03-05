public class FindMajority{
//Majority means the element must occur more than N/2 times in the array. The array has to be sorted.
	public static int find(int[] a){
		int majority = a[0];
		int count = 1;
		for (int i = 1 ;i < a.length; i++ ){
			if (majority == a[i]){
				count ++;
			}
			else if (count ==0){
				majority = a[i];
				count =1;
			}
			else count --;

			System.out.println(count);
		}
		
			return majority;
	}

	public static void main(String[] args){
		int[] a = {1,2,3,4,4,19,19};
		int[] b = {1,4,2,4,3,4,5,6,4,19,4};
		System.out.println(FindMajority.find(b));
	}
}
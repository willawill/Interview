public class BubbleSort{
	public static void bubble(int[] array){
		int n = array.length;
		boolean sorted = false;
		while ( !sorted ){
			n--;
			sorted = true;
		for (int i = 0; i < n; i++){
			if (array[i] > array[i+1]){
                array[i] = array[i] ^ array[i+1];
                array[i+1] = array[i] ^ array[i+1];
                array[i] = array[i] ^ array[i+1];
				sorted = false;
			}
		 }
		}
	}


	public static void main(String[] args){
		int[] a= {5,6,2,4,7,1};
		BubbleSort.bubble(a);
		System.out.println(a[0]);
	}

}
//Bubble sort can be used to test if the array is sorted.worst and avg cases are O(n^2)
public class InsertionSort{
	public static void sort(int[] array){
		for (int i = 1; i < array.length; i++){
			int j = i;
			int newValue = array[i];
			while ( j > 0 && array[j-1] > newValue){
				array[j] = array[j-1];
				j--;
			}
			array[j] = newValue;
		}

	}

	public static void main(String[] args){
		int[] array = {6,5,3,7,1};
		InsertionSort.sort(array);
		System.out.println(array[0]);
	}
}

/*Efficient for (quite) small data sets. Best case is the almost sorted array
which is O(n).Worst case is the array is sorted reverse order. O(n^2).
Stable
O(1) extra space
O(n2) comparisons and swaps
Adaptive: O(n) time when nearly sorted
Very low overhead
insertion sort is the algorithm of choice either when the data is nearly sorted (because it is adaptive) or when the problem size is small (because it has low overhead).

*/
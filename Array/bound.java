//Implement a range class called Bound.
public class Bound{

	public static void range(String A, char x){
		char[] array = A.toCharArray();
		int start = 0;
		int end = 0;
		if (array[0] == x){
			start = 0;
			end = upper_bound(array, array.length, x);
		}
		else if (array[array.length-1] == x){
			end = array.length - 1;
			start = lower_bound(array, array.length, x);
		}
		else {
			start = lower_bound(array, array.length, x);
		 	end = upper_bound(array, array.length, x) -1;
	}
		System.out.println(start + " " + end);
	
	}
	private static int binarySearch(char[] array, int low, int high, char x){
			int mid = 0;
			while (low <= high){
				mid = (low + high)/2;
			if (array[mid] == x) return mid;
			else if (array[mid] < x){
				low = mid +1;
			}
			else {
				high = mid - 1;
			}
		}
		return -1;
	}

	private static int lower_bound(char[] array, int size, char x){
		int low = 0;
		int high = size - 1;
		int mid = 0;
		while (low < high){
			mid = (low + high)/2;
			if (x > array[mid]){
				low = mid + 1;
			}
			else
				high = mid;
		}
		return low;
	}

	private static int upper_bound(char[] array, int size, char x){
		int low = 0;
		int high = size - 1;
		int mid = 0;
		while (low < high){
			mid = (low + high)/2;
			if (x < array[mid]){
				high = mid;
			}
			else{
				low = mid + 1;
			}

		}
		return low;
	}

	public static void main(String[] args){
		String A = "abbbbbcccceeeef";
		bound.range(A,'f');

	}
}
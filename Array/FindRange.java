public class FindRange{
	
	public static void main(String[] args){
		String A = "aaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbe";
		FindRange.range(A, 'b');
	}
	public static void range(String A, char x){
		char[] array = A.toCharArray();

		int low = 0;
		int high = A.length()-1;
		int mid = 0;
		int start = -1;
		int end = -1;
		if (array[0] == x) {
			start = 0;
			mid =  binarySearch(array, low, high, x);
			end =  Endrange(array, mid, high, x);
	
		}
		else if (array[array.length - 1] == x) {
			end = high;
			mid =  binarySearch(array, low, high, x);
			start =  Startrange(array, low, mid, x);
		}
		else {
			mid =  binarySearch(array, low, high, x);
			start =  Startrange(array, low, mid, x);
			end =  Endrange(array, mid, high, x);
		}
		System.out.println(start + " "+ end);

	}
	private static int Startrange(char[] array, int l, int h, char x){
		int m = 0;
		while (array[h] ==  x ){
			m =  binarySearch(array, l, h, x);
			h =  binarySearch(array, l, m-1, x);
			if (h == -1) return m;
		}
		return m;
	}

	private static int Endrange(char[] array, int l, int h, char x){
		int m = 0;
		while (array[l] == x ){
			m =  binarySearch(array, l, h, x);
			l =  binarySearch(array, m+1, h, x);
			if (l == -1){
				return m;
			}
			
		}
		return m;
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
}
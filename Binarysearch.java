public class Binarysearch{
	public static boolean Binarysearch(int[]A, int x, int low, int high){
		if ((high -low)<1) return false;
		int mid = (high + low)/2;
		if (x == A[mid]) {
			return true;
		}
			
		else if (x < A[mid]){
			return Binarysearch(A, x, low, mid);
			}
		else{
			return Binarysearch(A, x, mid+1, high);
			}

}

public static int binarySearch(int[] sorted, int first, int upto, int key) {
    
    while (first < upto) {
        int mid = (first + upto) / 2;  // Compute mid point.
        if (key < sorted[mid]) {
            upto = mid;     // repeat search in bottom half.
        } else if (key > sorted[mid]) {
            first = mid + 1;  // Repeat search in top half.
        } else {
            return mid;     // Found it. return position
        }
    }
    return -(first + 1);    // Failed to find key
}

	public static void main(String[] args){

	int[] A ={1,2,3,4,5,6,7};

	System.out.println(Binarysearch(A, 6, 0,A.length-1));
	System.out.println(binarySearch(A, 0, A.length-1,6));
}

}

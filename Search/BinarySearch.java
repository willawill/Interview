public class BinarySearch{
	
	public static int findMissing(int[] a, int n){
		int mid;
		int low= 0; int high = a.length-1;
		if (a[0] != 0) return 0;

		while ( low <= high){
			mid = low + ((high-low)>>1);
			System.out.println(mid);//Incase overflow
			if (a[mid] > mid){
				high = mid -1;
			}
			else{
				low = mid + 1;
			}
		}
		return low;
}
public static void main(String[] args){

	int[] a= {0,1,2,4,5,6,7,8};
	System.out.println(BinarySearch.findMissing(a,8));


	}

}
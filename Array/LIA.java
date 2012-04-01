public class LIA{
	public static int longestIA(int[] d){
		int[] b = new int[d.length];
		int len = 0;
		b[0] = d[0];
		for (int i = 1; i< d.length; i++){
			int index = binarySearch(b, len, d[i]);
			if (index <= len) b[index] = d[i];
			else{
				len++;
				b[len] = d[i];
			}

		}
			
		return len+1;
	}

	public static int binarySearch(int[] a, int end, int v){
		int low = 0;
		int high = end;
		if (v<a[0]) return 0;
		if (v>a[end]) return end+1;
		while (low <= high){
			int mid = (low + high)/2;
			if (low == high){
				if (a[low] == v) return low;
				else return low;
			}
			else{
				if (a[mid] == v) return mid;
				else if (a[mid] > v){
					high = mid;
				}
				else low = mid + 1;
			}
		}
		return -1;
	}
	public static void main(String[] args){
		int[] a = {4,5,6,-7,-8,9,10};
		System.out.println(LIA.longestIA(a));
	}
}
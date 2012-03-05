public class FindXFromRotatedArray{
	
	public static int find(int[] arr, int x){
		return find(arr, x, 0, arr.length-1);
	}

	private static int find(int[] arr,int x,  int left, int right){
		if (left > right) 
			return -1;
		int mid = (left+right) >>1;
		System.out.println("The mid is " + arr[mid]);
		if (arr[mid] == x) 
			return mid;
		if (arr[mid] > arr[left])//left side is sorted normally.
			{ 
				if (x >= arr[left] && x <= arr[mid])
					return find(arr, x, left, mid);
				else
					return find(arr, x, mid+1, right);		
			}
		else if (arr[mid] < arr[left]) //Right side is sorted normally.
		{
			if (x>=arr[mid] && x <= arr[right]){
				return find(arr,x,mid+1, right);
			}
			else{
				return find(arr, x, left, mid-1);
			}
		}
		else if (arr[mid] == arr[left]){
			if (arr[mid] != arr[right]){
				return find(arr, x, mid+1, right);
			}
			else{
				int result = find(arr, x, left, mid-1);
				if (result != -1){
					return result;
				}
				else{
					return find(arr, x, mid+1, right);
				}
			}
		}
		return -1;

	}
	public static void rotated(int[] arr, int d, int n){
		int gcd = gcd(d,n);
		int i,j,k;
		for (i = 0 ;i < gcd;i++){
			int temp = arr[i];
			j = i;
			while (true){
				k = j+d;
				if (k >= n)
			        k = k - n;
      			if (k == i)
        			break;
      			arr[j] = arr[k];
      				j = k;
    	}
    		arr[j] = temp;
		}
	}

	private static int gcd(int a, int b){
		if (b == 0) return a;
		else return gcd(b, a%b);
	}

	public static void main(String[] args){
		int[] a = new int[10];
		for (int i = 0; i < a.length; i++){
			a[i] = i;
		}
		findX.rotated(a, 2, 5);
		findX.rotated(a, 2, 5);
		System.out.println(findX.find(a, 4));
		for(int i = 0; i < a.length;i++){
			System.out.print(a[i]);
		}

	}

}

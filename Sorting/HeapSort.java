public class HeapSort{
	
	public static void heapSort(int[] array){
		for (int i = 1;i<array.length; i++){
			reHeapUp(array, i);
		}
			//printout(array);
		for (int i = array.length -1 ; i > 0; i--){
			swap(array, 0, i);
			printout(array);
			reHeadDown(array, i-1);
			printout(array);
		}


	}
	public static int largerChild(int[] a, int root, int size){
			int left = getLeft(root);
			int right = getRight(root);
			if (right <= size && a[left] > a[right]) return left;
			else return right;
		
	}
	public static void reHeadDown(int[] a, int size){
		int root = 0;
		while (root *2 +1 < size){//get the next max
			int maxChild = largerChild(a,root,size);
			int max = a[maxChild];
			int r = a[root];
			if (r >= max) break;
		
				a[root]= max;
				a[maxChild] = r;
				root = maxChild;
		
		}
	}
	public static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	public static void reHeapUp(int[] a, int bottom){//if root is smaller than its child.
		while (bottom > 0){
			int parent = parent(bottom);
			int b = a[bottom];
			int p = a[parent];
			if (p >= b) break;
			
				a[bottom] = p;
				a[parent] = b;
				bottom = parent;
			
		}
	}
	public static int parent(int i){ return (i-1)/2;}
	public static int getLeft(int i){ return 2*i +1;}
	public static int getRight(int i){ return 2*i +2;}
	public static void printout(int[] a){
		for (int i: a){
			System.out.print(i+" ");
		}
			System.out.println();
		
	}
	public static void main(String[] args){
		int[] a = {3,3,2,2,1,1,4,9,5};
		HeapSort.heapSort(a);
		
	}
}
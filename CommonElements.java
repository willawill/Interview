import java.util.HashSet;

public class CommonElements{

private int[] array1;
private int[] array2;
private static final int num = 1<<24;

public CommonElements(int[] a, int[] b){
this.array1 = a;
this.array2 = b;
}

public void findCommon(){
	int count = 0;
	if (array1.length == 0|| array2.length == 0)
		return;


	
	HashSet<Integer> first = new HashSet();
	for (int i = 0;i<array1.length;i++){
		count++;
		first.add(array1[i]);
	
	}
	for (int i = 0;i<array2.length;i++){
		int temp = array2[i];
		if (first.contains(temp)){
			System.out.println(temp);
}
			
}
	
}

public void findCommon2(){//Using hash array.
	int[] hash = new int[num];
	for (int i =0;i<array1.length;i++){
		int index = hash(array1[i]);
	
		while (hash[index] != 0){
			index++;
			if (index < num && hash[index]==0){// linear probing
				hash[index] = array1[i];
				break;				
		}
			else if (index > num){
				index = 0;
		}
		
		}
			if (hash[index] == 0){
			hash[index] = array1[i];
		}
}
		for ( int i = 0; i < array2.length; i++){
			int index = hash(array2[i]);
			while(true){
		
				if (index < num){
					if (hash[index] == 0)
						break;
			
				if (hash[index] == array2[i]){
					System.out.println(array2[i]);
					break;

				}
			}
			else if(index > num){
			index = 0;
			}
			index = index+1;
		}
	}			
}	


   public static int hash(Object obj) {  
        int hash = obj.hashCode();  
        hash += ~(hash << 9);  
        hash ^= (hash >>> 14);  
        hash += (hash << 4);  
        hash ^= (hash >>> 10);  
        hash = hash & (num - 1);  
        return hash;  
    } 

	public void findCommon3(){//without extra buffer. fastest.
		QuickSort.Quicksort(array1,0,array1.length-1);
		QuickSort.Quicksort(array2,0,array2.length-1);
		for (int i = 0;i<array1.length;i++){
		if( Binarysearch(array2, array1[i], 0, array2.length-1)){
			System.out.println(array1[i]);
}
		}
				

}

	public static boolean Binarysearch(int[]A, int x, int low, int high){
		if (high - low <1) return false;
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
public static void main(String[] args){

int[] a = {3,4,6,12,7,8,9,32};
int[] b = {3,4,32,5,12,76};
CommonElements c = new CommonElements(a, b);

long start1 = System.nanoTime();

c.findCommon();
long end1 = System.nanoTime();
System.out.println(end1-start1);


long start = System.nanoTime();
c.findCommon2();
long end = System.nanoTime();
System.out.println(end-start);

long start3 = System.nanoTime();
c.findCommon3();
long end3 = System.nanoTime();
System.out.println(end3-start3);
}
}

class QuickSort
{
   public static void swap (int A[], int x, int y)
   {
      int temp = A[x];
      A[x] = A[y];
      A[y] = temp;
   }

   // Reorganizes the given list so all elements less than the first are 
   // before it and all greater elements are after it.                   
   public static int partition(int A[], int f, int l)
   {
      int pivot = A[f];
      while (f < l)
      {
        
         while (A[f] < pivot) f++;
         while (A[l] > pivot) l--;
         swap (A, f, l);
      }
      return f;
   }

   public static void Quicksort(int A[], int f, int l)
   {
      if (f >= l) return;
      int pivot_index = partition(A, f, l);
      Quicksort(A, f, pivot_index);
      Quicksort(A, pivot_index+1, l);
   }

   // Usage: java QuickSort [integer] ...
   // All integers must be distinct

}

import java.io.*;
import java.util.*;

/*Notes:
1. Brute force, O(n^2). slowest()
2. sorted the array and use binary search to find element that sumes to certain X.O(nlogn) + O(n) modest()
3. Using hashmap insert is O(n) and fetch is O(n).quicker()

Hashmap's question:
http://javarevisited.blogspot.com/2011/02/how-hashmap-works-in-java.html

Binary search : recursive and in-loop. O(logn)
Quicksort: in-place sort O(nlog) 

In java, static method can not be instansed. Must be called by it's class name. e.g Binarysearch.Binarysearch().
Cons: The main disadvantage is that you cannot swap, override or choose method implementations at runtime.
Prons: Static variable sticks to the class but not instance, which is one fixed point in memory.Every instance can change the value of 
	static variable, but it can be manipulated without actually creating an instance.It's good for utily::methods.

Static method is associated to the class and class isn't first-class object. So static method can not be overrided or abstracted.
*/

class Binarysearch{
	public static boolean Binarysearch(int[]A, int x, int low, int high){
		if (low > high){
			return false;	
		}
		int mid = (high + low)/2;
		if (x == A[mid]) {return true;}

		if (x < A[mid]){
			return Binarysearch(A, x, low, mid);
			}
		else{
			return Binarysearch(A, x, mid+1, high);
			}
}

}
class Quicksort{
	public static void swap(int[] A, int x, int y){
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;

}
// Reorganizes the given list so all elements less than the first are 
// before it and all greater elements are after it. 
	public static int partition(int[]A, int first, int last){
		int pivot = A[first];
		while(first < last){
			while(A[first] < pivot) first++;
			while(A[last] > pivot) last--; 
			swap(A, first, last);
}
		return first;
		

}
public static void Quicksort(int[] A, int first, int last){
	if (first >= last ) return;
	int pivot = partition(A, first, last);
	Quicksort(A, first, pivot);
	Quicksort(A, pivot+1, last);
}

}
public class sumk{
	private int[] a;
	private int sum;
	public sumk(int[] a,int k){
		this.a = a;
		this.sum = k;
}
	public int[] getA(){
		return a;
}
	public int getSum(){
		return sum;
}
	public void setA(int[] a){
		this.a = a;}
	public void setSum(int s){
		this.sum = s;
		}
	public boolean slowest(){
		if (a.length<1) return false;
		for (int i=0; i<a.length;i++){
			for (int j=1+i;j<a.length;j++){
				if (a[i]+a[j]==sum)
					return true;
		}
}
		return false;

}
	public boolean modest(){
		if (a.length < 1) return false;
		Quicksort.Quicksort(a, 0, a.length-1);
		boolean isExist = false;
		for (int i = 1; i < a.length;i++){
			isExist = Binarysearch.Binarysearch(a, sum-a[i], i+1, a.length-1);
			if (isExist == true){
				return isExist;
	}
}
		return isExist;
}
	public boolean quicker(){
		HashMap<Integer, Integer> hs = new HashMap();
		for (int i =0; i<a.length; i++){
			hs.put(a[i], sum-a[i]);
}
		Iterator<Integer> i = hs.keySet().iterator();
		while(i.hasNext()){
			int tempKey = (int)i.next();
			int diff = sum - tempKey;
			if (hs.containsValue(new Integer(diff)))
					return true;			
	}
		return false;
}		
	public static void main(String[] args){
		int[] a = {3,5,7,2,12,8,4,34};		
		sumk target = new sumk(a, 15);
		System.out.println(target.slowest());
		System.out.println(target.modest());
		System.out.println(target.quicker());
}
}





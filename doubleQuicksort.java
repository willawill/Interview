import java.util.Random;

public class Quicksort implements sort{

public void swap(int[] list, int left, int right){
double temp = list[left];
list[left] = list[right];
list[right] = temp;
}

public int partition(int[] list, int left, int right){

	double pivot = list[left];
	System.out.println("pivot"+ Double.toString(pivot));
	while(left < right){
	  while(list[left] < pivot) left++;
	  while(list[right] > pivot) right--;
	  swap(list, left, right);
	}
	return left;
}

public void quicksort(int[] list, int left, int right){
	if (right <= left) return;
	int i = partition(list, left, right);
	quicksort( left, i);
	quicksort( i+1, right);

	}

public void sort(int[] list){

	quicksort(list, 0, list.length-1);
}
}



//swap
//partition

//quicksort;


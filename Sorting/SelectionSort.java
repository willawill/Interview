public class SelectionSort{
	public static void sort(int[] array){
		int minIndex = 0;
		for (int i = 0; i < array.length-1; i++){
			minIndex = i;
			for (int j = i +1; j< array.length; j++){
				if (array[j] < array[minIndex]){
					minIndex = j;
				}
			}
			if (minIndex != i){//Always puts the smallest before. 
						array[i] ^= array[minIndex]; 
						array[minIndex] ^= array[i]; 
						array[i] ^= array[minIndex]; 
					}		
			}
	}
public static void main(String[] args){
	int[] a = {6,5,4,7,1};
	SelectionSort.sort(a);
	System.out.println(a[0]);
}

	}
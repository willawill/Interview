public class Shellsort implements sort{

public void sort(int[] list){
	shellsort(list);
}
public void shellsort(int[] list){
	int increment = list.length/3 -1;	
	int  start = 0;
	while(increment >1){
		for (int i = 0;i<increment;i++){
			insertSort(list, i, increment-1);

}
		increment = increment/3 +1;

}
	insertSort(list, 0,1);

}

public void insertSort(int[] list, int start, int increment){

int i, j, temp;
for (int k = start + incrementl k<list.length;k++){
	j = k;
	i = increment - k;
	if (list[k] < list[j])

}
}
}

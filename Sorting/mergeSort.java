import java.util.Random;

public class MergeSort{

private int[] input;
private static Random generator = new Random();

public mergeSort(int size){
	input = new int[size];
 for ( int i = 0; i < size ; i++ ){
         input[i] = 10 + generator.nextInt(90);
	System.out.println(Integer.toString(input[i]));
}
}
public mergeSort(int[] a){
	this.input = a;
}

public void sort(){
	sortArray(0, input.length-1);
}

public void sortArray(int low, int high){
	if ((high - low) >= 1) {
		int middle1 = (high + low)/2;
		System.out.println(input[middle1]);
		int middle2 = middle1 + 1;
		System.out.println("split" + subarray(low, high));
		System.out.println("     " + subarray(low, middle1));
		System.out.println("     " + subarray(middle2, high));
		sortArray(low, middle1);
		sortArray(middle2, high);
		merge(low, middle1, middle2, high);
}
}

public void merge(int low, int middle1, int middle2, int high){

	int leftIndex = low;
	int rightIndex = middle2;
	int combineIndex = low;
	int[] combine = new int[input.length];
	System.out.println( "merge:   " + subarray( low, middle1 ) );
        System.out.println( "         " + subarray( middle2,high ) );
	
	while(leftIndex <=middle1 && rightIndex <= high){
		if (input[leftIndex] <= input[rightIndex]){
			combine[combineIndex++] = input[leftIndex++];
}
		else{
			combine[combineIndex++] = input[rightIndex++];
}
}
	if (leftIndex == middle2){
		while(rightIndex <= high){
			combine[combineIndex++] = input[rightIndex++];
}
}
	else{
		while(leftIndex <= middle1){
			combine[combineIndex++]= input[leftIndex++];
}
}

	for (int i = low; i<=high;i++){
		input[i] = combine[i];
	System.out.println( "         " + subarray( low, high ) );
      System.out.println();
}


}

 public String subarray( int low, int high )
   {
      StringBuffer temporary = new StringBuffer();

      // output spaces for alignment
      for ( int i = 0; i < low; i++ )
         temporary.append( "   " );

      // output elements left in array
      for ( int i = low; i <= high; i++ )
         temporary.append( " " + input[ i ] );

      return temporary.toString();
   } // end method subarray

   // method to output values in array
   public String toString()
   {
      return subarray( 0, input.length - 1 );
   } // end method toString 

public static void main(String[] args){
	mergeSort m = new mergeSort(8);
	m.sort();

}
}


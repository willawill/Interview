import java.util.Random;

public class MergeSort
{
   private int[] data; // array of values
   private static Random generator = new Random();

   // create array of given size and fill with random integers
   public MergeSort( int size )
   {
      data = new int[ size ]; // create space for array

      // fill array with random ints in range 10-99
      for ( int i = 0; i < size; i++ )
         data[ i ] = 10 + gxenerator.nextInt( 90 );
   } // end MergeSort constructor
   
   // calls recursive split method to begin merge sorting
   public void sort()
   {
      sortArray( 0, data.length - 1 ); // split entire array
   } // end method sort

   // splits array, sorts subarrays and merges subarrays into sorted array
   private void sortArray( int low, int high ) 
   {
      // test base case; size of array equals 1
      if ( ( high - low ) >= 1 ) // if not base case
      {
         int middle1 = ( low + high ) >> 1; // calculate middle of array
         int middle2 = middle1 + 1; // calculate next element over

         // output split step
         System.out.println( "split:   " + subarray( low, high ) );
         System.out.println( "         " + subarray( low, middle1 ) );
         System.out.println( "         " + subarray( middle2, high ) );
         System.out.println();

         // split array in half; sort each half (recursive calls)
         sortArray( low, middle1 ); // first half of array
         sortArray( middle2, high ); // second half of array

         // merge two sorted arrays after split calls return
         merge ( low, middle1, middle2, high );
      } // end if
   } // end method split
   
   // merge two sorted subarrays into one sorted subarray
   private void merge( int left, int middle1, int middle2, int right ) 
   {
      int leftIndex = left; // index into left subarray
      int rightIndex = middle2; // index into right subarray
      int combinedIndex = left; // index into temporary working array
      int[] combined = new int[ data.length ]; // working array

      // output two subarrays before merging
      System.out.println( "merge:   " + subarray( left, middle1 ) );
      System.out.println( "         " + subarray( middle2, right ) );
      
      // merge arrays until reaching end of either
      while ( leftIndex <= middle1 && rightIndex <= right )
      {
         // place smaller of two current elements into result
         // and move to next space in arrays
         if ( data[ leftIndex ] <= data[ rightIndex ] )
            combined[ combinedIndex++ ] = data[ leftIndex++ ]; 
         else 
            combined[ combinedIndex++ ] = data[ rightIndex++ ];
      } // end while
   
      // if left array is empty
      if ( leftIndex == middle2 )
         // copy in rest of right array
         while ( rightIndex <= right )
            combined[ combinedIndex++ ] = data[ rightIndex++ ];
      else // right array is empty
         // copy in rest of left array
         while ( leftIndex <= middle1 ) 
            combined[ combinedIndex++ ] = data[ leftIndex++ ];      

      // copy values back into original array
      for ( int i = left; i <= right; i++ )
         data[ i ] = combined[ i ];

      // output merged array
      System.out.println( "         " + subarray( left, right ) );
      System.out.println();
   } // end method merge

   // method to output certain values in array
   public String subarray( int low, int high )
   {
      StringBuffer temporary = new StringBuffer();

      // output spaces for alignment
      for ( int i = 0; i < low; i++ )
         temporary.append( "   " );

      // output elements left in array
      for ( int i = low; i <= high; i++ )
         temporary.append( " " + data[ i ] );

      return temporary.toString();
   } // end method subarray

   // method to output values in array
   public String toString()
   {
      return subarray( 0, data.length - 1 );
   } // end method toString 

public static void main(String[] args){
	MergeSort m  = new MergeSort(8);
	m.sort();
}

} 

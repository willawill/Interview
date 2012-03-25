import java.util.Arrays;
 
public class DutchFlag {
 
    public static void main(String[] args) {
        //Consider a case where the input numbers are not known prior.
        //Traverse the array once to pickup min and max values 
        int array[] = {9,11,8,11,9,8,11,9,8};
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        //Find the max and min in the three colors.j
        for(int i=0; i<array.length; i++){
                if(array[i] > high){
                        high = array[i];
                }
                if(array[i] < low){
                        low = array[i];
                }
        }
 
        int temp; //For swapping values
        int p = 0, q= array.length - 1;
        for(int i=0; i<q; i++) {
 
          if(array[i]==low){
                temp = array[i];
                array[i] = array[p];
                array[p] = temp;
                p++;
            }
            else if(array[i]==high){
                temp = array[i];
                array[i] = array[q];
                array[q] = temp;
                q--;
                i--;
            }
        }    
        System.out.println("The array after sort " + Arrays.toString(array));
    }
 }
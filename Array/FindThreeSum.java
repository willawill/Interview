import java.util.*;
public class FindThreeSum{
   
   public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num.length < 0 ) return null;
        Arrays.sort(num);
        ArrayList result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length ;i++){
            int j = i + 1;
            int k = num.length - 1;
            while (j < k){
                int sum_two = num[i] + num[j];
                if (sum_two + num[k] == 0){
                    ArrayList p = new ArrayList<Integer>();
                        p.add(num[i]);
                        p.add(num[j]);
                        p.add(num[k]);
                        if (!result.contains(p)){
                            result.add(p);
                        }
                        k--;
                        j++;
                    }
                   
                else if (sum_two + num[k] > 0){
                    k = k - 1;
                }
                else{
                    j++;
                }
            }
        }
        return result;
        
    }
 }
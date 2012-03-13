public class SearchInsert {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return search(A,0,A.length-1, target);
        
    }
    private int search(int[] A, int l, int h, int target){
        int mid = 0;
        if (l == h) return (A[l] >=target)?l:h+1;
        
        while (l <= h ){
            mid = l + ((h-l)>>1);
            
            if (A[mid] == target){ 
               return mid;            
            }
            else if (A[mid] > target){
                if (mid - l<=1) return (A[l]>=target)?l:l+1;
                h = mid -1;
            }
            else{
                if (h - mid == 1) return (A[h] >= target)?h:h+1;
                l = mid + 1;
    
    }
        }
                return h;
    
}
}
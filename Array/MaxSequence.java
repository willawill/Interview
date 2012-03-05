import java.util.*;
public class MaxSequence{
	
	public  Result findSub(int[] a){
		int maxSum = 0 ;
		int sum = 0; 
		int start = 0;
		int count = 0;
		if (a.length < 1) return new Result(0,0);
		for (int i = 0; i < a.length;i++){
			sum += a[i];
			if (sum > maxSum){
				maxSum = sum;
				count ++;
			}
			else if (sum < 0){
				sum = 0;
				start = i+1;
				count = 0;
			}
			else{
				count++;
			}
		}
			return new Result(start, start+count-1);
		
	}
class Result{
	int start;
	int end;
	public Result(int s, int e){
		start = s;
		end = e;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("The subsequence with max sum starts from ").append(start).append(" to ").append(end);
		return sb.toString();//Notice, stringbuffer to string.
	}
}
	public static void main(String[] args)
	{
		int[] x = {1,4,5,-7, 15, -2, 13};
		int[] y = {2,3,-8,-1,2,4,-2,3};
		MaxSequence ms = new MaxSequence();
		System.out.println(ms.findSub(x).toString());
	}
}
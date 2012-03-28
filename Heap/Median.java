import java.util.*;
public class Median{
	public	MaxHeap left = new MaxHeap();
	public 	MinHeap right = new MinHeap();
	
	public int median(int[] stream){
		int median = 0;

		for (int i = 0; i < stream.length; i++){
			median = getMedian(median,stream[i]);
			System.out.println(median);
		}

		return median;

	}
	private int getMedian(int m, int x){
		int flag = 0;
		
		if (left.getSize() > right.getSize()) flag = 1;
		else if (left.getSize() == right.getSize()) flag = 0;
		else flag = -1;

		
		switch(flag){

			case 1: 
				if (x < m){
					Node temp = left.remove();	
					right.insert(temp.value);
					left.insert(x);
				}//x goes to left
				else{
					right.insert(x);
				}
				m = (right.peek() + left.peek()) >> 1;
				break;
			case -1:
		
				if (x < m){//right > left
					left.insert(x);

				}
				else{
					Node temp = right.remove();
					left.insert(temp.value);
					right.insert(x);
				}
				m = (right.peek() + left.peek())/2;
				break;
		
			case 0:
				if (x < m){
					left.insert(x);
					m = left.peek();
				}
				else{

					right.insert(x);
					m = right.peek();
				}
				break;
	}
	System.out.println("Left "+ left.toString());
	System.out.println("Right "+ right.toString());
	
	return m;
}
	public static void main(String[] args){
		int[] a = {5,1,3,4,12,5,23,78,15,0,2,16,9};
		Median m = new Median();
		m.median(a);
	}
}
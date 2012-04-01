import java.util.*;
public class Intervals{

	public  int overlap(Seg[] sets, Seg newSeg){
		if (sets == null || newSeg == null || sets.length == 0) return -1;
		Arrays.sort(sets);
		int loc = lowerbound(sets, newSeg);
		if (sets[loc].end >= newSeg.end) return loc;
		else{
			loc--;
			while (loc > 0){
				if (sets[loc].end >= newSeg.end) return loc;
				else loc --;
			}
		}
		return -1;

	}
	private int lowerbound(Seg[] sets, Seg newSeg){
		int low = 0;
		int high = sets.length - 1;
		int mid = 0;
		while (low < high){
			mid = (low + high)/2;
			if (sets[mid].start < newSeg.start ){
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		return low;
	}

	public static void main(String[] args){
		Seg s1 = new Seg(1,2);
		Seg s2 = new Seg(2,6);
		Seg s3 = new Seg(3,9);
		Seg s4 = new Seg(4,7);
		Seg s5 = new Seg(7,11);
		Seg[] a = new Seg[5];
		a[0] = s1;
		a[1] = s2;
		a[2] = s3;
		a[3] = s4;
		a[4] = s5;
		Seg newS = new Seg(5,12);
		Intervals in = new Intervals();
		System.out.println(in.overlap(a, newS));
		
	}
	


}
class Seg implements Comparable<Seg>{
	int start;
	int end;
	public Seg(int s, int e){
		start = s;
		end = e;
	}
	public int compareTo(Seg s){
		if (start > s.start) return 1;
		else if (start < s.start) return -1;
		else return 0;
	}
}
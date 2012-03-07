import java.util.*;

public class OverlappedInterval{
	
	public  void isOverlapped(Point[] intervals){
		//if (intervals.length == 0) return false;
//Break ties and sort the starts ends.
		TreeMap<Integer,Integer> value = new TreeMap<Integer,Integer>();
		HashMap<Integer,String> indicator = new HashMap<Integer,String>();
		int i = 1;
		for (Point p:intervals){
			value.put(i, p.getStart());
			indicator.put(i,"S");
			i++;
			value.put(i, p.getEnd());
			indicator.put(i,"E");
			i++;
			}
		// for (Integer key: indicator.keySet()){
		// 	System.out.println(key + "/" + indicator.get(key));
		// }

		for (Entry<String, Integer> entry  : entriesSortedByValues(value)) {
		    System.out.println(entry.getKey()+":"+entry.getValue());
}
		// Stack pair = new Stack();
		// for (Integer key: value.keySet()){//value is ordered.
		// 	String indicate = indicator.get(key);
		// 	if (indicate == "E" ){
		// 		if (pair.empty()){
		// 			pair.push(indicate);
		// 		}
		// 		else{
		// 			return true;
		// 		}
		// 	}
		// 	else{
		// 		String temp = pair.peek();
		// 		if (temp != 'E'){
		// 			return true;
		// 		}
		// 		else{
		// 			pair.pop();
		// 		}
		// 	}
		// 	}
		// 	return false;
		}

	public static void main(String[] args){
		Point p1 = new Point(1,3);
		Point p2 = new Point(12,14);
		Point p3 = new Point(2,4);
		Point p4 = new Point(13,15);
		Point p5 = new Point(5,10);
		Point[] intervals = {p1,p2,p3,p4,p5};
		OverlappedInterval x = new OverlappedInterval();
		System.out.println();
		x.isOverlapped(intervals);
	}
}

class Point {
		int start;
		int end;
		public Point(int s, int e){
			start = s;
			end = e;
		}
		public int getStart(){
		return start;
	}
		public int getEnd(){
			return end;
		}
	}
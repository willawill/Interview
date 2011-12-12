import java.util.*;

public class QuickSelect{

private int[] a;

public QuickSelect(int[] a){
	this.a = a;
	
}
public  int QuickSelect(int k, int low, int high){
	ArrayList left = new ArrayList();
	ArrayList right = new ArrayList();

	int mid = (high+low)/2;
	System.out.println(mid);
	
	int pivot = a[mid];
	for (int i=0;i<a.length;i++){
		if (a[i]<pivot) {
			left.add(a[i]);
	}
		else if(a[i]>pivot) {
			right.add(a[i]);
	}
}
	if (left.size() >= k){
		return QuickSelect(k, 0, left.size()-1);

}
	else if (k > left.size()){
		return QuickSelect(k - left.size(), left.size(), a.length-1);
}
	else 
		return pivot;
}

public static void main(String[] args){

	int[] a = {5,6,2,4,8,12,9,-5};
	for (int i=0;i<a.length;i++){
		System.out.println(a[i]);
}
	QuickSelect q = new QuickSelect(a);
	
	System.out.println(	q.QuickSelect(2, 0, a.length-1));
}
}

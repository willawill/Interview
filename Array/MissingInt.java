import java.util.*;

public class MissingInt{

private static int[] a = {1,4,6,8,2,3,5,9,10,0};

public static void missingInt(){
	List<Integer> l1= new ArrayList();
	List<Integer> l2 = new ArrayList();
	for (int i = 0; i<11;i++){
		if ( i < a.length){
		l1.add(a[i]);
		}
		l2.add(i);
}
if (l2.removeAll(l1)){
	System.out.println(l2.get(0));
}

public static void missingInt(){
	int[] b = new int[a.length+1];
	int[] xor = new int[b.length];
	for (int i=0;i<a.length+1;i++){ //n+logn+n
		b[i] = i;
}

}
}
public static void main(String[] args){
	MissingInt.missingInt();

}
}

class myList {

private int[] list;
private int size;
private final int DEFAULT_CAPACITY = 20;
public myList(){
	list = new int[DEFAULT_CAPACITY];
	size = DEFAULT_CAPACITY;
}
public myList(int s){
	list = new int[s];
	size = s;
}

public void put(int item){
	if (list.length == size){
		expand();
}
	list[size++] = item;

}
public boolean contains(int item){
	for (int i=0;i<size;i++){
		if (list[i] == item) return true;

}
return false;
}

public boolean removeAll(myList l2){
	
  int x=0, i=0;
  for (i=0; i<size; i++) 
      if (!list.contains(l2[i])) 
          l2[x++] = l2[i];
  if (x != i) {
      Arrays.fill(l2, x, i, null);
      size = x;
      return true;
  } else {
      return false;
  }
  }
}
}

//convert two int[] to list.
// see what is left in the list1.

import java.util.Random;

public class doubleQuicksort{
private double[] list;
private static Random generator = new Random();

public doubleQuicksort(int size){
	list = new double[size];
	for(int i=0;i<size;i++){
	list[i]= 10.0 + generator.nextInt(90);
	System.out.print(list[i] + " ");
	}
}

public double[] getList(){
	return list;
}
public void swap(double[] list, int left, int right){
double temp = list[left];
list[left] = list[right];
list[right] = temp;
}

public int partition(double[] list, int left, int right){

double pivot = list[left];
System.out.println("pivot"+ Double.toString(pivot));
while(left < right){
  while(list[left] < pivot) left++;
  while(list[right] > pivot) right--;
  swap(list, left, right);
}
for (int i=0;i< list.length;i++){
	
	System.out.print(list[i] + " ");

}

return left;
}
public void quicksort(int left, int right){
if (right <= left) return;
int i = partition(list, left, right);
quicksort( left, i);
quicksort( i+1, right);

}

public static void main(String[] args){
doubleQuicksort q = new doubleQuicksort(8);
q.quicksort(0,7);
double[] a = q.getList();
	System.out.println("Final");
for (int i=0;i< a.length;i++){

	System.out.print(a[i] + " ");

}

}

//swap
//partition

//quicksort;
}

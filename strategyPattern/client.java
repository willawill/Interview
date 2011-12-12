public class client{
public static void main(String[] args){
int[] a = {4,5,6,7,23,19,25};
sortContext s = new sortContext();
s.setSorter(new Quicksort());
s.sortInt(a);
}
}

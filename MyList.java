import java.util.Arrays;
public class MyList<T>{
private static final int DEFAULT_CAPACITY = 10;
private Object[] elements;
private int size;

public MyList(){
	elements = new Object[DEFAULT_CAPACITY];
	size = DEFAULT_CAPACITY;

}
public MyList(int size){
	this.size = size;
	elements = new Object[size];
	

}

public int getSize(){
	return this.size;
}

public void add(Object ele){
	if (size == elements.length){
		ensurecapa();
}
	elements[size++] = ele;

}

public boolean contains(T ele){
	if (size == 0){ throw new IndexOutOfBoundsException("!!");}
	for (int i = 0; i< size;i++){
		if (elements[i] == ele)
			return true;
}
	return false;
}
public void remove(int index){
	if (index > elements.length){ throw new IndexOutOfBoundsException("!!");}
	for (int i = index;i<elements.length;i++)
		{
		elements[i] = elements[i+1];
}
	size --;

}

public T get(int index){
	if (index > elements.length) {throw new IndexOutOfBoundsException("!!");}
	return (T)elements[index];
}
private void ensurecapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}
public static void main(String[] args){
MyList<Integer> list = new MyList();
list.add(1);
list.add(3);
list.add(5);
System.out.println(list.getSize());
}
}

//week typing: uncheck. no type checking until any actual parameters passed.
/*strong typing:   
public set(Class<E> c, int s){
a = (E[]) Array.newInstance(c,s);
}

Difference between peek() and pop() is that peek() only returns the first item but pop() deletes the first item as well.
Difference between implementation using array and linkedlist:

1. No capacity limitation with linkedlist, only one constrctor are needed.

*/
public class Stack<T>{

private Object[] obj;
private int size= 0;;
private int top=-1;
private static final int DEFAULT_SIZE = 20;

public static void main(String[] args){
	Stack<Integer> s = new Stack();
	s.push(5);
	s.push(6);
	System.out.println(s.size());
	System.out.println(s.pop());
	System.out.println(s.peek());
}

public Stack(){
	obj = new Object[DEFAULT_SIZE]; 

}

public Stack(int s){
	obj = new Object[s]; 

	
}
public void push(T e){
	if (obj.length == size)
	{
	expandStack();
	}
	obj[++top] = (T) e;
	size++;
	
}
public T pop(){
	if (!isEmpty()){
		size --;
		return (T)obj[top--];
}
	else{
		throw new RuntimeException("Stack");

}
}
public T peek(){
	if (!isEmpty()){
		return (T)obj[top];
}
else {

	throw new RuntimeException("Stack");
}

}
public boolean isEmpty(){
	return (size == 0);
}

public int size(){
	return size;
}
private void expandStack(){
	int newSize = size * 2;
	Object[] newObj = new Object[newSize];
 	try {  
 	     System.arraycopy(obj, 0, newObj, 0, obj.length); 
		obj = newObj;
	}
	catch(ArrayStoreException e){
		System.out.println("Error");
} 
}
}

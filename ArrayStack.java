public class ArrayStack<T>{
/*The underlying datastructure is array*/
private final int DEFAULT_CAPACITY = 100;
private int top;
private T[] stack;

public ArrayStack<T>(){
	this. top = 0;
	this.stack = new T[DEFAULT_CAPACITY];

}
public ArrayStack<T>(int capacity){

	this. top = 0;
	this.stack = new T[capacity];

}

public T pop(){
	if (stack.isEmpty())
		{throw.EmptyStackException("stack");}
	top --;
	T element = stack[top];
	stack[top] = null;
	return element;
}

public void push(T element){
	if (stack.isFull()){
		stack = expandStack();

}
	++top;
	stack[top] = element;
	
}

public T peek(){
	return stack[top];

}

public boolean isEmpty(){
	return stack.size() == 0 ? true:false;
}

public T[] expandStack(){
	int size = stack.size();
	T[] expandStack = new T[size *2];
	for (int i=0;i < size;i++){
		expandStack[i] = stack[i]

}
	return expandStack;

}
}

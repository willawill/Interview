public class linkedStack(){


private LinkedNode top;
private int count;

public linkedStack(){
	count = 0;
	top = null;
}

public void push(T element){
	LinedNode n = new LinkedNode(element);
	top.setNext(n);
	top = n;
	count ++;
}

public T pop(){
	if (top == null){
	throw new EmptyCollectionException(“Stack”);

}
	T element = top.getElement();
	top = top.getNext();// top = top.next. Because first points to the next.
	count --;
	return element;

}

}

class LinkedNode<T>(){

private LinkedNode<T> next;
private T element;

public LinkedNode(){
	next = null;
	element = null;

}

public LinkedNode(T element){
	next = null;
	this.element = element;

}
public LinkedNode<T> getNext(){
	return next;
}
public void setNext(LinkedNode<T> n){
  	this.next = n;
}

public T getElement(){
	return element;
}

public void setElement(T element){
	this.element = element;
}
}

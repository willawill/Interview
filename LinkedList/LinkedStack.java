public class LinkedStack{


private LinkedListNode top;
private int count;

public LinkedStack(){
	count = 0;
	top = null;
}

public void push(Object element){
	LinkedListNode n = new LinkedListNode(element);
	n.setNext(top);
	top = n;
	count ++;
}

public Object pop(){
	if (top == null){
		return null;
}
	Object element = top.getValue();
	top = top.getNext();// top = top.next. Because first points to the next.
	count --;
	return element;

}
public Object peek(){
	return top.getValue();
}
public String toString(){
	String output="";
	while(top!=null){
		output += " " + top.getValue().toString();
		top = top.getNext();

	}
	return output;

}
public int getSize(){
	return count;
}

public static void main(String[] args){
	
	LinkedStack ls = new LinkedStack();
	ls.push(1);
	ls.push(2);
	System.out.println(ls.toString());
}


}


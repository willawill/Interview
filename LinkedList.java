import java.util.*;

class LinkedList{
	private LinkedListNode head;
	private int size;
	
	public LinkedList(){
		this.head = new LinkedListNode(null);
		this.size = 0;

}
	public void add(Object s){
		LinkedListNode temp = new LinkedListNode(s);
		LinkedListNode current  = head;
		while(current.getNext() != null){
			current = current.getNext();
}
		current.setNext(temp);
		this.size++;
}
	public void add(Object s, int index){
		LinkedListNode temp = new LinkedListNode(s);
		LinkedListNode current = head;
		for( int i = 0; i<index && current.getNext()!=null;i++){
			current = current.getNext();
}
		current.setNext(temp);
		this.size++;
}
	public Object get(int index){
		if (index < 0 || index > this.size){
			return null;
}
		LinkedListNode current = head;
		for (int i = 0 ; i < index ; i++){
			if (current.getNext() == null){
				return null;
	}
			current = current.getNext();
		
}
		return current.getValue();
}
	public boolean remove(Object s){
		LinkedListNode current = head;
		while(current.getNext() != null){
			if (current.getNext().getValue().equals(s))
				current.setNext(current.getNext().getNext());
				this.size --;
				return true;
}
		return false;
}
	public void removeDuplicates(){
		LinkedListNode current, previous;
		current = head;
		previous = null;
		HashSet table = new HashSet();
		while (current != null){
			System.out.println(current.getValue());
			if (table.contains(current.getValue())) {
				previous.setNext(current.getNext());
				current = current.getNext();
				System.out.println("previous is" + previous.getValue());		
	}
			else{
				previous = current;
				table.add(current.getValue());
				current = current.getNext();
				//System.out.println("current is" + current.getNext().getValue());
}
}
		
}
	 public String toString(){
			LinkedListNode current = head;
			String output ="";
			while (current != null){
				output += current.getValue();
			}
			return output;

	}

	public int getSize(){
		return this.size;
}

	private class LinkedListNode{
		Object value;
		LinkedListNode next;
	

	 public	LinkedListNode(Object _o){
		value = _o;
		next = null;
		
}
	public	LinkedListNode getNext(){
		return next;
}
	public void setNext(LinkedListNode node){
		next = node;
}
	public Object getValue(){
		return value;
}
	public void setValue(Object _o){
		this.value = _o;
}
}
	public static void main(String[] args){
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(1);
		l.add(4);
		l.add(5);
		l.removeDuplicates();
		int count = l.getSize();
		System.out.println(l.toString());

}
}

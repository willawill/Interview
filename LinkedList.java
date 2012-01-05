import java.util.*;

class LinkedList{
	private LinkedListNode head;
	private int size;
	
	public LinkedList(){
		this.head = null;
		this.size = 0;

}
	public void add(Object s){
		LinkedListNode temp = new LinkedListNode(s);
		if (this.size == 0){
			head = temp;
			this.size++;
		}
		else{
			LinkedListNode current  = head;
			while (current.getNext() != null){
				current = current.getNext();
		}
		current.setNext(temp);
		this.size++;
	}
}
	public void insert(Object s, int index){
		LinkedListNode temp = new LinkedListNode(s);

		//Invalid index.It also can be treated as a head.
		if (index < 0 ){
			temp.setNext(head);
			head = temp;	
			this.size ++;
		}
		//Any index exceeds the size will be appended to the tail.
		else if (index > size){
			this.add(s);
		}
		else{
			LinkedListNode current = head;
			LinkedListNode previous = null;
			for( int i = 0; i < index - 1 && current.getNext() != null ; i++){
			current = current.getNext();

			}
		previous = current;
		current = current.getNext();
		previous.setNext(temp);
		temp.setNext(current);
		this.size++;
		}
}
	public Object get(int index){
		if (index < 0 || index > this.size){
			return null;
}
		LinkedListNode current = head;
		for (int i = 1 ; i <= index ; i++){
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
			if (table.contains(current.getValue())) {
				previous.setNext(current.getNext());
		}
			else{
				previous = current;
				table.add(current.getValue());
		}
			current = current.getNext();
			
	}
}

	 public String toString(){
			LinkedListNode current = this.head;
			String output ="The elements are ";
			while (current != null){
				output += " " + current.getValue();
				current = current.getNext();
			}
			return output;

	}

	public int getSize(){
		return this.size;
}
	public LinkedListNode getHead(){
		return this.head;
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
		l.add(4);
		l.add(5);
		l.insert(6,2);
		// //l.removeDuplicates();
		l.removeDupNoHashset();
		// IntWrapper i = new IntWrapper();
		// LinkedListNode k = l.returnKth2(l.getHead(),2, i);
		// System.out.println(k.getValue());
		 System.out.println(l.get(2));
		System.out.println(l.toString());

}
public int count = 0;
	public void removeDupNoHashset(){
		if (head == null) return;
		LinkedListNode current, previous;
		LinkedListNode runner;
		previous = head;
		current = previous.getNext();
		
		while (current != null){
			runner = head;	//Look backward to find duplicates.
			while ( runner != current){
				if (runner.getValue() == current.getValue()){
						LinkedListNode temp = current.getNext();
						previous.setNext(temp);
						current = temp;
						break;

				}
				count ++;
				runner = runner.getNext();

			}

			if (runner == current){
				previous = current;
				current = current.getNext();
				count ++;

			}

		}		
	}
		
public LinkedListNode returnKth(int k){
	if ((k < 0)||(k > this.size)){
		return null;
	}
	int index = 0;
	LinkedListNode current = this.head;
	while (current != null){
		if (index == (this.size-k)){
			return current;
		}
		index ++;
		current = current.getNext();

	}
	return null;
}

private class IntWrapper{
	public int value = 0;
}
public LinkedListNode returnKth2(LinkedListNode node , int k, IntWrapper i){
	if ((head == null)|| k < 0) return null;
	LinkedListNode n = returnKth2(head.getNext(),k, i);
	i.value = i.value + 1;	
	 if ( i.value == k){
	 	return node;
	 }
	return n;
}

}

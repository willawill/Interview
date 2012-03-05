import java.util.*;
public class RemoveDuplicate{
	
	public static HashSet remove(LinkedList l){
		LinkedListNode head = l.getHead();
		if (head==null) return null;
		HashSet table = new HashSet();
		while (head != null){
			table.add(head.getValue());
			head = head.getNext();
		}
		return table;
	}
	public static void removeInplace(LinkedList l ){
		LinkedListNode head, current, previous;
		head = l.getHead();
		while( head != null){
			previous = null;
			current = l.getHead();
			while (current != head){
				if (current.getValue() == head.getValue()){
					previous.setNext(current.getNext());
				}
				else{
					previous = current;
					}				
					current = current.getNext();
				}

				head = head.getNext();
		}
	}
	public static void main(String[] args){
		LinkedList list = new LinkedList();
		list.add(1);
		list.add(5);
		list.add(7);
		list.add(3);
		list.add(7);
		System.out.println(list.toString());
		HashSet result = new HashSet();
		RemoveDuplicate.removeInplace(list);
		System.out.println(list.toString());
		
		result = RemoveDuplicate.remove(list);
		Iterator i = result.iterator();
		while (i.hasNext()){
			System.out.println(i.next());
	}
}
}
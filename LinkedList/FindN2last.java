import java.util.*;
public class FindN2last{
	public static LinkedListNode findlastN(LinkedList l, int n){
		if (l.getHead() == null) return null;
		LinkedListNode head = l.getHead();
		LinkedListNode head2 = l.getHead();
		while (n != 0){
			head2 = head2.getNext();
			n--;
		}
		while (head2 != null){
			head = head.getNext();
			head2 = head2.getNext();
		}

		return head;

	}
	public static void main(String[] args){
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(15);
		l.add(13);
		l.add(12);
		l.add(5);
		System.out.println(l.toString());
		System.out.println((FindN2last.findlastN(l,2)).getValue());
	}

}
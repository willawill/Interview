public class FindIntersection{

		public static boolean findIntersection(LinkedList l1, LinkedList l2){
			if (l1 == null || l2 == null || l1.size() == 0|| l2.size() == 0){
				return true;
			}

			int s1 = l1.size();
			int s2 = l2.size();
			Node current,p;
			if (s1 >= s2) {
				current = s1.getHead();
				p = s2.getHead();
			}
			else{
				current = s2.getHead();
				p = s1.getHead();
			}
			int diff = Math.abs(s1-s2);
			for (int i = 0;i<diff;i++){
				current = current.getNext();
			}
			while (current!=null){
				if (current == p) return true;
				current = current.getNext();
				p = p.getNext();
			}
			return false;
		}
public static void main(String[] args){
	LinkedList l1 = new LinkedList();
	LinkedList l2 = new LinkedList();
	l1.add(1);
	l1.add(1);
	l1.add(1);
	l1.add(1);
	l1.add(1);
	l2.add(3);
	//Merge tail
	Node h2 = l2.getHead();
	Node h1 = l1.getHead();
	for (int i = 0 ; i < 2; i ++){
		h1 = h1.getNext();
	}
	h2.setNext(h1);

}
class Node{
	int value;
	Node next;
	public Node getNext(){
		return next;
	}
	public void setNext(Node x){
		next = x;s
	}
}
class LinkedList{
	Node head;
	int size;
	public int size(){
		return size;
	}
	public Node getHead(){
		return head;
	}
	public void add(int s){
		Node temp = new Node(s);
		if (this.size == 0){
			head = temp;
			this.size++;
		}
		else{
			Node current  = head;
			while (current.getNext() != null){
				current = current.getNext();
		}
		current.setNext(temp);
		this.size++;
	}
}
}



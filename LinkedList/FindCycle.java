public class FindCycle{
	
	public static LinkedListNode findCycle(LinkedList l){
	LinkedListNode p1 = l.getHead();
	LinkedListNode p2 = l.getHead();
	while (p1.getNext()!= null){
		p1 = p1.getNext();
		p2 = p2.getNext().getNext();

		if (p1 == p2) break;
	}
	if (p1!=p2) return null;
	p1 = l.getHead();
	while(p1 != p2){
		p1 = p1.getNext();
		p2 = p2.getNext();
	}
	return p2;
	
	}
	public static void main(String[] args){
		LinkedList l = new LinkedList();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(5);
		LinkedListNode p1 = l.getHead();
		while (p1.getNext()!= null){
			p1 = p1.getNext();
		}
		LinkedListNode x = new LinkedListNode(15);
		x.setNext(l.getHead().getNext().getNext());
		p1.setNext(x);
		System.out.println(FindCycle.findCycle(l).getValue());
		
	}
}
// http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/

import java.util.Random;
public class CopyListwithRandPointer{
	
	public static LinkedList copy(LinkedList l){
		LinkedList l2 = new LinkedList();
		Node p1 = l.getHead();
		while (p1.getNext() != null){
			l2.add(p1.getValue());
		}//Deep copy of l1.
		Node p2 = l2.getHead();
		
		p1 = l.getHead();
		p2 = l2.getHead();

		while (p1 != null && p2 != null){
			p2.setRand(p1);
		}
		p1 = l.getHead();
		p2 = l2.getHead();
		
		while (p1 != null && p2!= null){
			p2.setRand(p2.getRand().getRand());
			p1 = p1.getNext();
			p2 = p2.getNext();
		}

	return l2;

}

	class RandPointerNode{

		int value;
		RandPointerNode next;
		RandPointerNode rand;

		public RandPointerNode(int x){
			this.value = x;
			next = null;
			rand = null;
		}

		public void setRand(RandPointerNode l){
			Random generator = new Random();
			int len = l.getSize();
			int index = generator.nextInt(len - 1);
			RandPointerNode temp = l.getHead();
			for (int i = 0; i <= index; i++){
				temp = l.getNext();
			}
			this.rand = temp;
		}
	}
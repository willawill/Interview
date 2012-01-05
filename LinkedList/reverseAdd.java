public class reverseAdd{
	public  LinkedList reverseAdd(LinkedList l1, LinkedList l2){
		int len1 = l1.getSize();
		int len2 = l2.getSize();
		if (len1 > len2){
			l2 = padding(l2, len1-len2);
		}
		else{
			l1 = padding(l1, len2-len1);
		}

	LinkedList result = new LinkedList();
	int carry = 0;
	int value = 0;
	LinkedListNode head1 = l1.getHead();
	LinkedListNode head2 = l2.getHead();
	while (head1!=null && head2!=null){
			value = head1.getValue().intValue() + head2.getValue().intValue();
			LinkedListNode temp = new LinkedListNode(value);
			result.add(temp);
			head1 = head1.getNext();
			head2 = head2.getNext();	
}

	return result;

	}


	public LinkedList padding(LinkedList l, int padding){
		while (padding > 0){
			l.insert(0,-1);
			padding --;

		}
		return l;
	}
	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		l1.add(5);
		l1.add(1);
		l2.add(2);

		reverseAdd ra = new reverseAdd();
		System.out.println(ra.reverseAdd(l1, l2).toString());


	}
}
import java.lang.*;

public class reverseAdd{
	private static int Loc = Integer.MAX_VALUE;
	private LinkedList result;


	public reverseAdd(){
		result = new LinkedList();
	}

	public LinkedList getResult(LinkedList l1, LinkedList l2){
		return this.reverseAdd(l1, l2);
	}
	private LinkedList reverseAdd(LinkedList l1, LinkedList l2){
		int len1 = l1.getSize();
		int len2 = l2.getSize();
		if (len1 > len2){
			l2 = padding(l2, len1-len2);
		}
		else{
			l1 = padding(l1, len2-len1);
		}

		int carry = 0;
		int value = 0;
		LinkedListNode head1 = l1.getHead();
		LinkedListNode head2 = l2.getHead();
		while (head1!=null && head2!=null){
			if (carry != 0){	
				 value = value + carry;

			}
			value += Integer.valueOf(head1.getValue().toString()) + Integer.valueOf(head2.getValue().toString());
			
			if (value >= 10){
			 	result.add(value%10);
			 	carry = value/10;
			 }
			 else{
			 	result.add(value);
			 	carry = 0;
			 }
			value = 0;
			System.out.println("Head1 is " + head1.getValue());
			System.out.println("Head2 is " + head2.getValue());
			head1 = head1.getNext();
			head2 = head2.getNext();	
	}
	if (carry != 0){
		result.add(carry);
	}
		return result;
	}


	public LinkedList padding(LinkedList l, int padding){
		while (padding > 0){
			l.insert(0,Loc);
			padding --;

		}
		return l;
	}

	// @Override public String toString(){
	// 	LinkedStack ls = new LinkedStack();
	// 	LinkedListNode head = result.getHead();
	// 	String output = "";
		
	// 	while (head != null){
	// 		ls.push(head.getValue());
	// 		head = head.getNext();
	// 	}
	// 	while (ls.getSize() != 0){
	// 		output += ls.pop();

	// 	}
	// 	return output;

	// }

	public static void main(String[] args){
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		l1.add(5);
		l1.add(1);
		l1.add(3);
		l2.add(2);
		l2.add(9);

		reverseAdd ra = new reverseAdd();
		LinkedList temp = ra.getResult(l1, l2);
		System.out.println(temp.toString());
	}
}
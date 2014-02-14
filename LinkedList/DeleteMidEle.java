public class DeleteMidEle{
	private LinkedList l;

	public DeleteMidEle(LinkedList l){
		this.l = l;
	}
	public void deleteMidEle(int s){
		if ( l.getSize() == 0 ) return;
		LinkedListNode current = l.getHead();
		LinkedListNode newS = null;
		while (current != null){
			if (current.getValue() == s){
				newS = current;
				break;
			}
			current = current.getNext();
		}
		newS.setValue(newS.getNext().getValue());
		newS.setNext(newS.getNext().getNext());
	}

	public static void main(String[] args){
		LinkedList l = new LinkedList();
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(11);
		DeleteMidEle dme = new DeleteMidEle(l);
		dme.deleteMidEle(6);
		System.out.println(l.toString());

	}

}
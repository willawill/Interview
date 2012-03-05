

public class DeleteMidEle{
	private LinkedList l;

	public DeleteMidEle(LinkedList l){
		this.l = l;
	}
	public void deleteMidEle(Object s){
		LinkedListNode newS = new LinkedListNode(s);
		LinkedListNode temp = newS.getNext();
		newS.setValue(temp.getValue());
		newS.setNext(temp.getNext());

	}
	public static void main(String[] args){
		LinkedList l = new LinkedList();
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(11);
		DeleteMidEle dme = new DeleteMidEle(l);
		dme.deleteMidEle(7);
		System.out.println(l.toString());

	}

}
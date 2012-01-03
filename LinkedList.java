class LinkedList{
	private LinkedListNode head;
	private int size;
	
	public LinkedList(){
		this.head = new LinkedListNode(null);
		this.size = 0;

}
	public void add(Object s){
		LinkedListNode temp = new LinkedListNode(s);
		LinkedListNode current  = head;
		while(current.getNext() != null){
			current = current.getNext();
}
		current.setNext(temp);
		this.size++;
}
	public void add(Object s, int index){
		LinkedListNode temp = new LinkedListNode(s);
		LinkedListNode current = head;
		for( int i = 0; i<index && current.getNext()!=null;i++){
			current = current.getNext();
}
		current.setNext(temp);
		this.size++;
}
	public Object get(int index){
		if (index < 0 || index > this.size){
			return null;
}
		LinkedListNode current = head;
		for (int i = 0 ; i < index ; i++){
			if (current.getNext() == null){
				return null;
	}
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

	public int getSize(){
		return this.size;
}

	private class LinkedListNode{
		Object value;
		LinkedListNode next;
	
	 public LinkedListNode(Object _o,LinkedListNode _next){
		value = _o;
		next = _next;
}
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
		l.add(123);
		l.add(124);
		l.remove(1);
		int count = l.getSize();
		System.out.println(count);

}
}

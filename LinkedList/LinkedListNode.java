public class LinkedListNode{
		Object value;
		LinkedListNode next;
	

	 public	LinkedListNode(Object _o){
		this.value = _o;
		this.next = null;
		
}
	public	LinkedListNode getNext(){
		return next;
}
	public void setNext(LinkedListNode node){
		this.next = node;
}
	public Object getValue(){
		return this.value;
}
	public void setValue(Object _o){
		this.value = _o;
}
}

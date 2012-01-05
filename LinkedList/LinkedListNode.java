public class LinkedListNode{
		Object value;
		LinkedListNode next;
	

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

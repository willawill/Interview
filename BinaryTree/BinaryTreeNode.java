import java.lang.*;

public class BSTNode extends Comparable<BSTNode>{
	private BSTNode left;
	private BSTNode right;
	private Object data;

	public int compareTo(Object o){
		if (data > o) 
			return 1;
		else if (data < o) 
			return -1;
		else{ 
			return 0;
	}
}
	public BSTNode(Object o){
		left = null;
		right = null;
		data = o;
}
	public BSTNode getLeft(){
		return left;
	}
	public BSTNode getRight(){
		return right;
	}

	public Object getData(){
		return data;
	}

	public void setLeft(BSTNode newLeft ){
		left = newLeft;
	}
	
	public void setRight(BSTNode newRight){
		right = newRight;
	}

	public void setData(Object o){
		data = o;
}
		
public static void main(String[] arg){
	BSTNode a = new BSTNode("12");
	System.out.println(a.compareTo("15"));

}



}
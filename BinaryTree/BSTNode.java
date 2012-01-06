import java.lang.*;

public class BSTNode{
	private BSTNode left;
	private BSTNode right;
	private int key;

	public int compareTo(int o){
		if (key > o) 
			return 1;
		else if (key < o) 
			return -1;
		else{ 
			return 0;
	}
}
	public BSTNode(int o){
		left = null;
		right = null;
		key = o;
}
	public BSTNode getLeft(){
		return left;
	}
	public BSTNode getRight(){
		return right;
	}

	public int getKey(){
		return key;
	}

	public void setLeft(BSTNode newLeft ){
		left = newLeft;
	}
	
	public void setRight(BSTNode newRight){
		right = newRight;
	}

	public void setKey(int o){
		key = o;
}

}
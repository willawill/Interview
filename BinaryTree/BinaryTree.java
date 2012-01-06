public class BinarySearchTree{
	
	private BinarySearchTreeNode root;
	private int size;

	public BinaryTree(){
		root = null;
		size = 0;
	}

	public boolean insert(Object o){
		if (root == null){
			
			BinaryTreeNode newNode = new BinaryTreeNode(o);
			root = newNode;
			size++;
			return true;
		}
		BinaryTreeNode current  = root;
		while (current != null){
			if (current.getLeft() == null){
				current.setLeft(o);
				size ++
				return true;
			}
			else if(current.getRight() == null){
				current.setRight(o);
				sie ++;
				return true;	
			}
			else{
				insert
			}

		}

	}

	public Binar
	private BinaryTreeNode find(Object o){
		BinaryTreeNode current =  root;
		while (current != 0){
			if (current.getLeft().getData().equals(o)){
				return current.getLeft();
			}
			else if(current.getRight().getData().equals(o)){
				return current.getRight();
			}
			else{
				
			}

		}

	}

}
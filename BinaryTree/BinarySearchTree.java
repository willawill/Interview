import java.util.*;
import java.lang.*;
public class BinarySearchTree{
	
	private BSTNode root;
	private int size;
	BSTNode current = root;//it's a global temp variable.

	//Factory method 
	public BinarySearchTree(){
		root = null;
		size = 0;
	}
	BSTNode build(int o){
		BSTNode node = new BSTNode(o);
		//System.out.println(o);
		return node;
	}

	public boolean isEmpty(){
		return root==null ? true : false;
	}
	public int getSize(){
		return root == null ? 0 : size;
	}
	//Return the size of subtree whose root is node.
	public int getSize(BSTNode node){
		return root == null? 0 : (getSize(node.getLeft())+1+getSize(node.getRight()));
	}
	//Insert a new node.
	public void insert(int o){
			current = insert(root, o);
			if (isEmpty() && current !=null){
				root = current;
			}
			size ++;
			
	}
	//Insert the node recursively.
	private BSTNode insert(BSTNode node, int o){
		if (node == null){
			node = build(o);
			return node;	
	}
		else if( node.compareTo(o) < 0 )//New node goes to right
			{
				if (node.getRight() == null) node.setRight(build(o));
				else{
					node = insert(node.getRight(), o);
				}
			}
		else if(node.compareTo(o) >= 0){
				if (node.getLeft() == null) node.setLeft(build(o));
				else{
					node = insert(node.getLeft(),o);
				}
		}
		return null;
	}
	
	public boolean search(int o){
		if (isEmpty()) {
			return false;
		}
		else{
			current = find(root, o);

			if (current != null) 
				return true;
			else 
				return false;
		}
	}
	private BSTNode find(BSTNode node, int o){
		while (node.getKey() != o && node != null){
			
		if(node.compareTo(o) > 0){
			node = node.getLeft();
		}
		else {
			node = node.getRight();
			}
		}
		return node;			

	}

	public boolean delete(int o){
		if (isEmpty()) return false;
		else {
			 	BSTNode parent = root;
			 	boolean found = false;
				
				while (current != null && !found){
					if (current.compareTo(o) == 0){
						found = true;
						size --;
						if (current == parent.getLeft()){
							parent.setLeft(replacement(current));
						}
						else if(current == parent.getRight()){
							parent.setRight(replacement(current));
						}
						else{
							current = replacement(current);
							return true;
						}

					}
					else{
						parent = current;
						if (current.compareTo(o) > 0){
							current = current.getLeft();
						}
						else{
							current = current.getRight();
						}
					}
				}
				if (!found){
					return false;
				}
				else{
					return true;
				}
			}
		}
	
	private BSTNode replacement(BSTNode node){
		BSTNode result = null;
		BSTNode parent = node;
			
		if (node.getLeft() == null && node.getRight() == null){
			result = null;
		}
		else if (node.getLeft() != null && node.getRight() == null){
			result = node.getLeft();
		}
		else if (node.getLeft() == null && node.getRight() != null){
			result = node.getRight();
		}
		else{
			current = node.getRight();
		}
		while (current.getLeft() != null){
			parent = current;
			current = current.getLeft();

		}
		if (node.getRight() == current){
			current.setLeft(node.getLeft());
		}
		else {
			parent.setLeft(current.getRight());
			current.setRight(node.getRight());
			current.setLeft(node.getLeft());
		}
		result = current;
		return result;
		}

	public  void orderWalk(int type){
		int[] result = new int[size];
		switch(type){
			case 1: result = inorderWalk(root);
			break;
	// 		case 2: result = preorderWalk(node);
	// 		break;	
	 }
		for (int i:result){
			System.out.println(i);
		}
	}

	public void preorderWalk(){
		preorderWalk(root);
	}
	private void preorderWalk(BSTNode node){
		if (node != null){
			System.out.println(node.getKey());
			preorderWalk(node.getLeft());
			preorderWalk(node.getRight());
		}
	}
	public void inorderWalk2(){
		inorderWalk2(root);
	}
	private void inorderWalk2(BSTNode node){
		if (node != null) {
			inorderWalk2(node.getLeft());
			System.out.println(node.getKey());	
			inorderWalk2(node.getRight());
		}
		
	}
	private int[] inorderWalk(BSTNode node){
		int[] result = new int[size];
		int count = 0;
		Stack s = new Stack(this.size);
		current = root;
		boolean done = false;
		while(!done){
			if (current != null){
				s.push(current);
				current = current.getLeft();
			
			}
			else{
				if (!s.isEmpty()){
					current = s.pop();
					result[count] = current.getKey();
					current = current.getRight();
					count ++;
				}
				else{
					done = true;
				}
			}
		}
		return result;
	}

	
	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(5);
		bst.insert(6);
		bst.insert(2);
		bst.insert(8);
		bst.insert(1);
		bst.insert(3);
		bst.insert(7);
		bst.inorderWalk2();
	//	System.out.println(bst.getSize());
		System.out.println();
	}


}
	class Stack{
		BSTNode[] array;
		int size;

		Stack(int len){
			array = new BSTNode[len];
			size = 0;
		}
		BSTNode pop(){
			return array[--size];
		}

		void push(BSTNode x){
			array[size] = x;
			size++;
		}
		BSTNode peek(){
			return array[size];
		}
			
		boolean isEmpty(){
			return size==0 ? true:false;
		}
		public String toString(){
			String output = "";
			while (size !=0){
				output += this.pop().getKey();
			}
			return output;
	
	}
}

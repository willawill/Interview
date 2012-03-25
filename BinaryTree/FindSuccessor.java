/*
Find successor of node in a binary search tree.The time complecity is O(height)*/

public class FindSuccessor{
	public Node succ(Node n, Node root){
		if (n == null) return null;
		if (n.right != null) return minValue(n.right);
		Node succ = null;
		while (root != null){
			if (n.value < root.value){//left tree;
				succ = root;
				root = root.left;
			}
			else if (n.value > root.value){
				
				root = root.right;
			}
			else
				break;
		}
		return succ;

	}
	public Node minValue(Node n){
		while (n.left != null){
			n = n.left;
		}
		return n;
	}

}

class Node{
	Node left;
	Node right;
	int value;
}
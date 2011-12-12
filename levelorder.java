know the root find the height.

Using queue and list;

enqueue(root);
add root to the rear of list.
if root.hasChildren, dequeue C, put c's children into queue.
算循环了多少次，就是多少层。

if it's binary tree, height = logn.
level order can also be used to valid binary tree.

valid it's a balanced tree: if height <= logn else return false;

longpath happends in leftsubtree-right rotation.
longpath happends in right subtree  -- left rotation.
longpath happends in leftsubtree of right child---rightleft rotation.
longpath happends in right subtree of left child--leftright rotation.

public class BinaryTree(){

private int count;
private BinarTreeNode root;

public BinaryTree(){
	root  = null;
}

public BinaryTree(BinaryTreeNode root, BinaryTree left, BinaryTree right){

	if root != null
		this.root = root;
}
}

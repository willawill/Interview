public class BST {

	public Node root = null; // Root node of the tree
	Node currentNode = root;

	// Checks to see if is empty. Prints out message if it is.
	public boolean IsEmpty() {
		if (root == null)
			return true;
		return false;
	}// End of IsEmpty

	Node create(int number) {
		Node node = new Node();
		node.number = number;
		node.parent = null;
		node.leftChild = null;
		node.rightChild = null;
		return node;
	}

	public int size() {
		return size(root);
	}

	public int size(Node node) {
		if (node == null) return 0;
		else {
			return size(node.leftChild) + 1 + size(node.rightChild);
		}
	}

	// Method to insert a number into the tree.
	public void insert(int number) {

		currentNode = add(root, number);
		if (IsEmpty() == true && currentNode != null)
			root = currentNode;
	// 	currentNode = root;
	 }

	Node add(Node node, int number) {
		if (node == null)// create a new node.
		{
			node = create(number);
			return node;

		} else if (number < node.number)// if the number is less than the node,
										// go to the left child.
		{
			if (node.leftChild != null)
				add(node.leftChild, number);
			else
				node.leftChild = create(number);

		} else if (number >= node.number)// if the number is greater than the
											// node, go to the right child
		{
			if (node.rightChild != null)
				add(node.rightChild, number);
			else
				node.rightChild = create(number);

		}

		return null;

	}// end BSTNode insert

	public void find(int number)
	{
		IsEmpty();

		currentNode = find(root, number);

		System.out.println("Search returned Node: " + currentNode.number);
		System.out.println("Node's left child: " + currentNode.leftChild);
		System.out.println("Node's right child: " + currentNode.rightChild);

	}//End of find

	Node find(Node currentNode, int number) {
		// currentNode = root; //sets the root node to the current node for
		// searching purposes

		while (currentNode.number != number && currentNode != null) {
			if (number < currentNode.number) // if number we are searching for
												// is less than the node <strong
												// class="highlight">search</strong>
												// left sub <strong
												// class="highlight">tree</strong>
			{
				currentNode = currentNode.leftChild;
			} else if (number > currentNode.number)// if number we are searching
													// for is greater than the
													// node <strong
													// class="highlight">search</strong>
													// right sub <strong
													// class="highlight">tree</strong>
			{
				currentNode = currentNode.rightChild;
			} else // if number we are searching for is equal to the node
					// <strong class="highlight">search</strong> right sub
					// <strong class="highlight">tree</strong>
			{
				currentNode = currentNode.rightChild;
			}
		}

		return currentNode;

	}// End of RBTNode find

	public Node getRoot() {
		return root;
	}

	public void display() {
		display(root);
	}

	private void display(Node input) {

		if (input == null) {
			return;
		}

		display(input.leftChild);
		System.out.println(input.number);
		display(input.rightChild);

	}// End of display

	public static boolean isBST(Node x){
		if(x == null) return false;
		else if(x.leftChild == null && x.rightChild == null) return true;
		else if(x.leftChild != null && x.rightChild == null){
			if(x.leftChild.number > x.number) return false;
			else return isBST(x.leftChild);
		} else if(x.rightChild != null && x.leftChild == null){
			if(x.rightChild.number < x.number) return false;
			else return isBST(x.rightChild);
		} else {
			if(x.leftChild.number > x.number || x.rightChild.number < x.number) return false;
			else return isBST(x.leftChild) && isBST(x.rightChild);
		}
	}

	//Deletion
	public void delete(int value) {
		root = delete(root, value);
	}

	private Node delete(Node x, int value) {
		if(x == null) return null;
		if(value < x.number) 
			{
				x.leftChild = delete(x.leftChild, value);
			}
		else if(value > x.number) 
			{
				x.rightChild = delete(x.rightChild, value);
			}
		else if(x.leftChild != null && x.rightChild != null){
			x.number = minValue(x.rightChild);
			x.rightChild = removeMin(x.rightChild);
		} 
		else{ 
			x = (x.leftChild != null) ? x.leftChild: x.rightChild;
		}
		return x;
	}

	private Node removeMin(Node x) {
		if(x == null) return null;
		else if(x.leftChild != null) {
			x.leftChild = removeMin(x.leftChild);
			return x;
		} else {
			return x.rightChild;
		}
	}

	//Max Depth
	public int maxDepth(){
		return maxDepth(root);
	}

	private int maxDepth(Node x){
		int lDepth, rDepth;
		if(x == null) return 0;

		lDepth = maxDepth(x.leftChild);
		rDepth = maxDepth(x.rightChild);
		return (lDepth > rDepth ? lDepth : rDepth) + 1;
	}

	//Min Value
	public int minValue() {
		return minValue(root);
	}

	private int minValue(Node node) {
		if(node == null) return 0;
		Node current = node;
		while(current.leftChild != null) {
			current = current.leftChild;
		}

		return current.number;
	}

	//Order walk

	public void inorderWalk() {
		inorderWalk(root);
	}

	private void inorderWalk(Node x) {
		if( x != null){
			inorderWalk(x.leftChild);
			System.out.println(x.number);
			inorderWalk(x.rightChild);
		}
	}

	public void preorderWalk() {
		preorderWalk(root);
	}

	private void preorderWalk(Node x) {
		if(x != null){
			System.out.println(x.number);
			preorderWalk(x.leftChild);
			preorderWalk(x.rightChild);
		}
	}

	public void postorderWalk() {
		postorderWalk(root);
	}

	private void postorderWalk(Node x) {
		if(x != null) {
			postorderWalk(x.leftChild);
			postorderWalk(x.rightChild);
			System.out.println(x.number);
		}
	}

	//has Path Sum
	public boolean hasPathSum(int sum){
		return hasPathSum(root, sum);
	}

	private boolean hasPathSum(Node node, int sum) {
		if(node == null) return sum == 0;
		else {
			int subSum = sum - node.number;
			return hasPathSum(node.leftChild, subSum) || hasPathSum(node.rightChild, subSum);
		}
	}

	//Print Path
	public void printPaths(){
		int[] path = new int[1000];
		printPaths(root, path, 0);
	}

	private void printPaths(Node node, int[] path, int pathLen) {
		if(node == null) return;
		path[pathLen] = node.number;
		pathLen++;

		if(node.leftChild == null && node.rightChild == null)
			printArray(path, pathLen);
		else {
			printPaths(node.leftChild, path, pathLen);
			printPaths(node.rightChild, path, pathLen);
		}
	}

	private void printArray(int[] ints, int len) {
		for(int i = 0; i<len; i++) {
			System.out.print(ints[i] + " ");
		}
		System.out.println();
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {
		if(node != null){
			mirror(node.leftChild);
			mirror(node.rightChild);

			Node temp = node.leftChild;
			node.leftChild = node.rightChild;
			node.rightChild = temp;
		}
	}

	public void doubleTree() {
		doubleTree(root);
	}

	private void doubleTree(Node node) {
		Node oldLeft;
		if (node == null) return;

		doubleTree(node.leftChild);
		doubleTree(node.rightChild);

		oldLeft = node.leftChild;
		node.leftChild = new Node(node.number);
		node.leftChild.leftChild = oldLeft;
	}

	public static void main(String[] args)
	{
		BST BST = new BST();

		int inputArray[] = new int[10];
//		inputArray[0] = 26;
//		for(int i = 1; i < 10; i++){
//			inputArray[i] = i*i;
//		}
//		for(int i = 0; i < 10; i++){
//			RBT.insert(inputArray[i]);
//		}
		BST.insert(5);
		BST.insert(3);
		BST.insert(4);
		BST.insert(8);
		BST.insert(9);
		BST.insert(1);
		BST.insert(12);
		System.out.println(BST.hasPathSum(5));
		
		//BST.delete(111);
		// System.out.println("===IN ORDER WALK===");
		// BST.inorderWalk();
		// System.out.println("===PRE ORDER WALK===");
		// BST.preorderWalk();
		// System.out.println("===POST ORDER WALK===");
		// BST.postorderWalk();

		//BST.display(BST.getRoot());
		System.out.println();


		/*
		Scanner console = new Scanner(System.in);

		System.out.println("How many numbers would you like to enter into the Red Black Tree?");
		int k = console.nextInt();

		int inputarray[] = new int[k];

		for(int i=0; i< k; i++)
		{

			System.out.println("Please enter the " + (i+1)+ " number: ");
			inputarray[i]= console.nextInt();
		}

		System.out.println("\n\n****Display Start****");
		for(int i=0; i<k; i++)
		{
			RBT.insert(inputarray[i]);
		}
		System.out.println(isBST(RBT.root));
		RBT.display(RBT.getRoot());
		System.out.println(RBT.root);
		*/
	}

}// end of class RBTTree

class Node
{
	int number;
	Node parent;
	Node leftChild;
	Node rightChild;

	Node(){
		number = 0;
		leftChild = null;
		rightChild = null;
	}

	Node(int data){
		number = data;
		leftChild = null;
		rightChild = null;
	}

}
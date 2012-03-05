public class makeTree{

	public static BT makeTree(int[] inorder, int[] preorder){


	}
	public static int[] makeTree(int[] inorder, int[] preorder, int left, int right, int pos){
		if (left > right) return null;

		if (inorder.length != preorder.length) return null;
		//Parse two orders. 
		int root = preorder[0];
		int left = getIndex(inorder, root) - 1;//0 - left 
		int right = inorder.length - left; //right - length -1;

	}
		public int getIndex(int[] array, value){
			for (int i = 0; i < array.length; i++){
				if (array[i] == value) return i;
			}
			return -1;
		}

	public static void main(String[] args){
		int[] preorder = {1,2,3,4,5,6,7};
		int[] inorder = {3,2,4,1,5,6,7};
	}

	class BTNode{
		int value;
		BTNode left;
		BTNode right;
		public BTNode(int value){
			value = value;
			left = null;
			right = null;
		}
	}
}
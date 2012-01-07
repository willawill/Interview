import java.util.Random;
public class MinimalHeightTree extends BinarySearchTree{

	
	public MinimalHeightTree(){
		super();
	}

	public void createMHT(int array[]){
		this.setRoot(createMHT(array, 0, array.length-1));
	}
	private BSTNode createMHT(int arr[], int start, int end){
		if (end < start) return null;
		int mid = (start + end)>>1;
		BSTNode n = new BSTNode(arr[mid]);
		n.setLeft(createMHT(arr, start, mid-1));
		n.setRight(createMHT(arr, mid+1, end));
		return n;

	}
	public static void main(String[] args){
		MinimalHeightTree mht =  new MinimalHeightTree();
		int[] a = new int[10];
		Random generator = new Random();
		for (int i = 0; i < 10 ;i++){
			a[i] = i;
		}
		mht.createMHT(a);
		// System.out.println();
		 System.out.println(mht.getRoot().getKey());

	}

}
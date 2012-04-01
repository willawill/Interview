import java.util.*;

public class MinHeap{

	private int size;
	private ArrayList<Node> heapArray;
	public int getSize(){
		return heapArray.size();
	}

	public MinHeap(){
		heapArray = new ArrayList<Node>();
		size = 0;
	}

	public boolean insert(int value){
		Node newNode = new Node(value);
		heapArray.add(size, newNode);
		heapUp(size++);
		return true;
	}

public Node remove(){//Return the root;
		Node root = heapArray.get(0);
		heapArray.set(0, heapArray.get(size-1));
		heapArray.remove(size-1);
		size = size - 1;
		if (size != 0){
			heapDown(0);
		}
		return root;
	}

	public int peek(){
		return heapArray.get(0).value;
	}

	private void heapUp(int index){
		int parent = (index - 1)/2;//start from the right child
		Node bottom = heapArray.get(index);
		
		while (index > 0 && heapArray.get(parent).value > bottom.value){//Minheap set the biggest node on the top

			heapArray.set(index, heapArray.get(parent));
			index = parent;
			parent = (parent - 1)/2;
		}
		heapArray.set(index, bottom);
		

	}
	private void heapDown(int index){
		int smallerChild = 0;
		Node top = heapArray.get(index);
		while (index < heapArray.size()/2){
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;


			if (rightChild < size){
				smallerChild = (heapArray.get(leftChild).value <= heapArray.get(rightChild).value) ? leftChild:rightChild;
			}
			else{
				smallerChild = leftChild;
			}
			if (top.value <= heapArray.get(smallerChild).value) break;
			heapArray.set(index, heapArray.get(smallerChild));
			index = smallerChild;

		}
		heapArray.set(index, top);
	}

	public String toString(){
		StringBuffer sb =new StringBuffer();
		if (heapArray.size()!=0){
			for (Node n: heapArray){
				sb.append(n.value + " ,");

				
				}
	}
		return new String(sb);
	}

}




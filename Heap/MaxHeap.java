import java.util.*;

public class MaxHeap{

	private int size;
	private ArrayList<Node> heapArray;
	
	public int getSize(){
		return heapArray.size();
	}

	public MaxHeap(){
		heapArray = new ArrayList<Node>();
		size = 0;
	}
	public int peek(){
		return heapArray.get(0).value;
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

	private void heapUp(int index){
		int parent = (index - 1)/2;//start from the right child
		Node bottom = heapArray.get(index);
		while (index > 0 && heapArray.get(parent).value <= bottom.value){//Maxheap set the biggest node on the top
			heapArray.set(index, heapArray.get(parent));
			index = parent;
			parent = (parent - 1)/2;
		}
		heapArray.set(index, bottom);

	}
	private void heapDown(int index){
		int largerChild = 0;
		Node top = heapArray.get(index);

		while (index < heapArray.size()/2){
			top = heapArray.get(index);
			
			int leftChild = 2 * index + 1;
			int rightChild = leftChild + 1;
			if (rightChild < size){
				largerChild = (heapArray.get(leftChild).value >= heapArray.get(rightChild).value) ? leftChild:rightChild;
			}
			else{
				largerChild = leftChild;
			}
			if (top.value >= heapArray.get(largerChild).value) break;
			heapArray.set(index, heapArray.get(largerChild));
			index = largerChild;

		}
		heapArray.set(index, top);
	}

	public String toString(){
		StringBuffer sb =new StringBuffer();
		if (!heapArray.isEmpty()){
			for (Node n: heapArray){
				sb.append(n.value + " ,");
		}
	}
		return new String(sb);
	}

}

class Node implements Comparable<Integer>{
	public int value;
	public Node(int v){
		this.value = v;
	}

	public int compareTo(Integer i){
		if (value < i) return -1;
		else if (value > i) return 1;
		else return 0;
	}

	public int equals(Integer i){
		return compareTo(i);
	}

}


import java.util.*;
public class SkipList{
	
	private SkipListNode head;
	private final int MAX_LEVEL= 6;
	private final double factor = 0.5;
	private int level = 0;
	
	public SkipList(){
		head = new SkipListNode(0,MAX_LEVEL);
	}
	public boolean contains(int value){
		SkipListNode temp = head;
		for (int i = level;i>0;i--){
			while (temp.next[i] != null && temp.next[i].getValue() < value){
				temp = temp.next[i];
			}
		}
		temp = temp.next[0];
		return temp != null && (temp.getValue() == value);
	}
	public void insert(int value){
		SkipListNode temp = head;
		SkipListNode[] updates = new SkipListNode[MAX_LEVEL+1];

		int lvl = getLevel();


	}

public void insert(E value)
 87     {
 88         SkipNode<E> x = header;	
 89         SkipNode<E>[] update = new SkipNode[MAX_LEVEL + 1];
 90 
 91         for (int i = level; i >= 0; i--) {
 92 	    while (x.forward[i] != null && x.forward[i].value.compareTo(value) < 0) {
 93 	        x = x.forward[i];
 94 	    }
 95 	    update[i] = x; 
 96 	}
 97 	x = x.forward[0];
 98 
 99 
100         if (x == null || !x.value.equals(value)) {        
101             int lvl = randomLevel();
102       
103             if (lvl > level) {
104 	        for (int i = level + 1; i <= lvl; i++) {
105 	            update[i] = header;
106 	        }
107 	        level = lvl;
108 	    }
109 
110             x = new SkipNode<E>(lvl, value);
111 	    for (int i = 0; i <= lvl; i++) {
112 	        x.forward[i] = update[i].forward[i];
113 	        update[i].forward[i] = x;
114 	    }
115 
116         }
117     }






	private int getLevel(){
		int lvl = (int)(Math.log(1.-Math.random())/Math.log(1.-P));
		return Math.min(lvl, MAX_LEVEL);
	}


}

class SkipListNode{
	private int value;
	public SkipListNode[] next;//On the same level

	public int getValue(){
		return this.value;
	}
	public void setValue(int x){
		this.value = x;
	}

	public SkipListNode(int x, int level){
		value = x;
		next = new int[level+1];
	}
}
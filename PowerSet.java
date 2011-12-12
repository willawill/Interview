import java.util.*;

public class PowerSet<T>{

	private Set<T> input;
	private Set<ArrayList<T>> powerSet;


	public PowerSet(){
		this.input = new HashSet();

	}
	public PowerSet(Set<T> in){
		this.input = in;
		this.powerSet = new HashSet<ArrayList<T>>();
	}
	public void setInput(HashSet<T> in){
		this.input = in;
	}
	public Set<T> getInput(){
		return input;
	}
	public Set<ArrayList<T>> getPowerSet(){
		return powerSet;
	}

	public void powerSet(Set<T> rest){
		T head = null;
		ArrayList<T> inner;
		while(!rest.isEmpty()){
			if (powerSet.isEmpty()){
				powerSet.add(new ArrayList());//Set initialization.

			}
			else{
				Iterator<T> ir = rest.iterator();//Get next first element in the rest
				while (ir.hasNext()){
					head = (T)ir.next();
					break;
				}	
				rest.remove(head);
				Set<ArrayList<T>> tempSet = new HashSet<ArrayList<T>>();
				Iterator i = powerSet.iterator();
				for (ArrayList temp:powerSet){
					inner = new ArrayList();
					tempSet.add(temp);
					inner.addAll(temp);//Union head with each exists list.
					inner.add(head);
					tempSet.add(temp);
					tempSet.add(inner);
				}
				powerSet=tempSet;

			}
		}
	}


	public static void main(String[] args){
		Set<Character> input = new HashSet();
		input.add('a');
		input.add('B');
		input.add('C');
		input.add('D');
		input.add('E');
		input.add('4');

		PowerSet<Character> power = new PowerSet(input);
		power.powerSet(input);
		HashSet<ArrayList<Character>> output = (HashSet<ArrayList<Character>>)power.getPowerSet();
		Iterator<ArrayList<Character>> i = output.iterator();

		while(i.hasNext()){
			Object temp = i.next();
			System.out.println(temp.toString());
		}
		System.out.println("There are " + output.size() +" items inthe power set");

	}
}

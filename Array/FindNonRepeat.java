import java.util.*;
public class FindNonRepeat{
	public static char find(String txt){
		char[] input = txt.toCharArray();
		HashMap<Character, Integer> table = new HashMap<Character, Integer>();
		
		for (char i : input){
			if (table.get(i)!= null){
				table.put(i, (table.get(i) + 1));
			}
			else{
				table.put(i, 1);
			}
		}
		for (char i: input){
			if (table.get(i) == 1) return i;
		}
		return '1';
		}

		public static void main(String[] args){
			String x = "ababccdd";
			System.out.println(FindNonRepeat.find(x));
		}

}

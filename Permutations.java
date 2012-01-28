import java.util.*;
public class Permutations {
   public int count = 0;
   private ArrayList<String> permutations;

	public Permutations(){
		this.permutations = new ArrayList<String>();
}
   public  void perm1(String s) { 
			perm1("", s); 
			Iterator i = this.permutations.iterator();
			while (i.hasNext()){
				System.out.println(i.next());
}		
	}

   private  void perm1(String prefix, String s) {

        int N = s.length();
//	System.out.println("String is " +s);
        if (N == 0){
            this.permutations.add(prefix);//All the chars are printed out.
	    }
        else {
            for(int i = 0; i < N; i++){
//		System.out.println("i is " + i +" prefix is "+ prefix);               
		perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
		
            }
        }
    }
	public ArrayList<String> getPermu(){
	return this.permutations;
}
    public static void main(String[] args) {
	Permutations p = new Permutations();
	String alphabet = "Tee";

       p.perm1(alphabet);
    }
}




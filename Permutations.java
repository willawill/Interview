public class Permutations {
   public int count = 0;
   public  void perm1(String s) { perm1("", s); 
	System.out.println(count);
		
	}

   private  void perm1(String prefix, String s) {
	this.count++;
	
        int N = s.length();
	System.out.println("String is " +s);
        if (N == 0)
            System.out.println(prefix);//All the chars are printed out.
        else {
            for(int i = 0; i < N; i++){
		System.out.println("i is " + i +" prefix is "+ prefix);               
		return perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
		
            }
        }
    }
	public int getCount(){
	return count;
}
    public static void main(String[] args) {
	Permutations p = new Permutations();
	       String alphabet = "Teeee";
	System.out.println(alphabel);
       p.perm1(alphabet);
    }
}




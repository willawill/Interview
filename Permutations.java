public class Permutations{
	
	public static void perm(String s){
		perm1("", s);
	}
	private static void perm1(String prefix, String s){
		int N = s.length();
		if (N == 0){
			System.out.println(prefix);
		}
		else{
			for (int i = 0; i < N; i++){
				perm1(prefix + s.charAt(i), s.substring(0,i) + s.substring(i+1, N));
			}
		}
	}

	public static void main(String[] args){
		String x = "perm";
		Permutations.perm(x);
	}

}
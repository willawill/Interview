public class StringMatch{

	public static int BF(String pat, String txt){
		int N = pat.length();
		int M = txt.length();
		if (N == 0 || M == 0 || M < N) return -1;//Handle exceptions
		for (int i = 0 ;i <= M - N; i++){
			int j;
			for (j= 0; j < N;j++){
				if (txt.charAt(i+j) != pat.charAt(j)) break;
			}
			if (j == N) return i;
		
		}
		return M;
	}

	    public static int BF2(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) j++;
            else { i -= j; j = 0;  }//Discard the matched part.
        }
        if (j == M) return i - M;    
        else        return N;        
    }

	public static void main(String[] args){
		String input = "ABCDEFG";
		String pattern  = "CD";
		System.out.println(StringMatch.BF2(pattern, input));
	}

}
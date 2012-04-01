public class LastWord{
	public static int lens(String s){
		if (s == null) return 0;
		int len = 0;
		boolean isWord = false;
		s = s.trim();
		String[] input= s.split(" ");
		return input[input.length-1].length();
			}
	private boolean isSpace(char c){
		return (c == ' ');
	}

	public static void main(String[] args){
		String a = "        This is a good time to speak";
		System.out.println(LastWord.lens(a));
	}
}
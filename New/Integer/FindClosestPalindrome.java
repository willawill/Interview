public class FindClosestPalindrome{

	public static int findClosest(int x){
		int num = Math.abs(x);
		char[] input = Integer.toString(num).toCharArray();
		int p1 = findPalindrome(input);
		int diff = num - p1;
		int p2 = 0;
		input = Integer.toString(num+diff).toCharArray();
		p2 = findPalindrome(input);
		int result = Math.abs(num-p1)>Math.abs(num-p2)?p2:p1;
		return x >0?result:-result;
	}

	private static int findPalindrome(char[] input){
		if (isPalindrome(input)) return Integer.parseInt(new String(input));
		int len = input.length;
		int i = 0;
		while (i<=len/2){
			input[len-i-1] = input[i];
			if (isPalindrome(input)) break;
			i++;
		}
		return Integer.parseInt(new String(input));
	}

	private static boolean isPalindrome(char[] input){
		int len = input.length;
		if (len == 1) return true;
		int i = 0;
		while (i <= len/2){
			if (input[i] != input[len-i-1]) {
				return false;
			}
			i++;
		}
		return true;
	}

	public static void main(String[] args){
		System.out.println(FindClosestPalindrome.findClosest(1999));
	}
}
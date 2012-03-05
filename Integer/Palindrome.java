import java.util.*;
public class Palindrome{
	
	public static boolean palindrome(int num){//O(n)
		if (num > Integer.MAX_VALUE||num < Integer.MIN_VALUE){
			return false;
		}
		char[] temp = Integer.toString(num).toCharArray();
		int low = 0;
		int high = temp.length -1;
		while (temp[low] == temp[high] && low < high){
			low++;
			high--;
		}
		System.out.println(high);
			if (low == high|| low>high ) {//odd and even
				return true;
			}
			else return false;
	}

	public static boolean isPalindrome(final int num) {
   	 	final String s = Integer.toString(num);
    	return s.equals(new StringBuffer(s).reverse().toString());
	}

	public static boolean isPalindromeAnagram(String text) { // O(n) time space is O(1)
    BitSet bs = new BitSet(27);
    for (int i = 0; i < text.length(); i++) {
        char ch = text.charAt(i);
        if (('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z'))
            bs.flip(ch % 32);
    }
    return bs.cardinality() <= 1;
}
	public static boolean isPalindromeAnagram(String text) {
    	int count = 0;
    	for (int i = 0; i < text.length(); i++) {
        char ch = text.charAt(i);
        if (ch + Integer.MIN_VALUE - 'A' <= 'z' + Integer.MIN_VALUE - 'A')
            count ^= 1 << ch;
    }
    return Integer.bitCount(count % (1 << 'z') & ~1) <= 1;
}
	public static void main(String[] args){
		System.out.println(Palindrome.isPalindrome(1523443251));
		System.out.println(Palindrome.isPalindromeAnagram("I am sorry yrros ma I"));
		
	}

}
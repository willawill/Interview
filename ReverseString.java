public class ReverseString{

private String s;

public ReverseString(String s){
	this.s = s;
}

public String ReverseString(){//Using extra stack.O(n)
	char[] chars = s.toCharArray();
	Stack<Character> s = new Stack(chars.length);
	for (char c:chars){
		s.push(c);
}
	for (int i =0;i<chars.length;i++){
		chars[i] = s.pop();
}		
	return new String(chars);
}
public String ReverseString2(){//Swap the array, 
            if ((null == s) || (s.length() <= 1)) {
                return s;
            }
            char[] chars = s.toCharArray();
            int right = chars.length - 1;
            for (int left = 0; left < right; left++) {
                char swap = chars[left];
                chars[left] = chars[right];
                chars[right--] = swap;
            }
            return new String(chars);
        }

public String Reverse3(String s)//XOR
{
	if (null==s|| (s.length()<1)){
	return s;
}
	
	char[] chars = s.toCharArray();
	int len = s.length() -1;
	for(int i = 0; i < len;i++,len--){
		chars[i] ^= chars[len];
		chars[len] ^= chars[i];
		chars[i] ^= chars[len];
		
}
	return new String(chars);

}

	
public static void main(String[] args){
	String s = "hello world";

	ReverseString rs = new ReverseString(s);
	long start = System.nanoTime();
	String s1 = rs.ReverseString();
	long end = System.nanoTime();
//System.out.println(end - start);
//	 start = System.nanoTime();
//	String s2=rs.ReverseString2();
// end = System.nanoTime();
//System.out.println(end - start);
	 start = System.nanoTime();
	String s3 = (rs.Reverse3(s));
	String s4 = (rs.Reverse3(s3));
 end = System.nanoTime();
System.out.println(end - start);

System.out.println(s3);
System.out.println(s4);

}
}



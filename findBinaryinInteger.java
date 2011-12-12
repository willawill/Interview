

public class findBinaryinInteger{

	private int i;
	private int signedCount;//Count for how many 1 in the (i)_2
	private int unsignedCount;

	public findBinaryinInteger(){
	};
	public findBinaryinInteger(int n){
		this.i = n;
		this.signedCount = 0;
		this.unsignedCount = 0;
}
	public int getI(){
		return i;
}
	public int getSignedCount(){
		return signedCount;
}
	public void setI(Integer i){
		this.i = i;
	}


	public void setSignedCount(int c){
		this.signedCount =c;
}
	public void setUnsignedCount(int c){
		this.unsignedCount = c;
	}
	public void findBinary(){
		String signedString = Integer.toString(i,2);
		System.out.println("The signed binary string is " +signedString);
		String unsignedString = Integer.toBinaryString(i);
		System.out.println("The unsigned binary string is " +unsignedString);
		char[] signed = signedString.toCharArray();
		char[] unsigned = unsignedString.toCharArray();
		setSignedCount(countForx(signed, 1));
		setUnsignedCount(countForx(unsigned, 1));
		System.out.println(signedCount);
		System.out.println(unsignedCount);
}
	public int countForx(char[] a, int x){
		int local_count = 0;
		for (char c : a){
			if (Character.toString(c).equals( Integer.toString(x))){
				local_count += 1;
			}
		}
		return local_count;
}


public static void main(String[] args){
	findBinaryinInteger x = new findBinaryinInteger(-4);
	x.findBinary();

}
}


/*Nodes on that:
1. Convert int to string: Integer.toString(i); 
2. Convert int to binary: Signed: Integer.toString(i,2) Unsigned: Integer.toBinaryString(i)
3. String to char array: char[] a = x.toCharArray();
4. Compare two strings for content: s1.equals(s2);

http://www.javacoffeebreak.com/faq/
*/


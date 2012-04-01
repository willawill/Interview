public class ReverseByte{
	

	public static void main(String[] args){
		int a = 15 ;
		
		a = ((a & 0x55)<<1)|((a & 0xAA) >> 1);
		a = ((a & 0x33) << 2)|((a & 0xCC) >> 2);
		a = ((a & 0x0F) << 4)|((a & 0xF0) >> 4);
		System.out.println(a);

/*First we don''t treate it as an integer.*/
		int b = 15;
		String output = String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0');
		char[] chars = output.toCharArray();
		int i = 0; 
		int j = chars.length -1;
		for (; i < chars.length/2; i++){
			chars[i] ^= chars[j];
			chars[j] ^= chars[i];
			chars[i] ^= chars[j];
			j--;
		}
		System.out.println(new String(chars));

/*Then we make it as an integer.
* Take every bit from input and put in the output.
*/

int c = 18;
int chDst = c & 1; 
 for(i=0; i<8; i++) {
 chDst = (chDst <<1)|(c &1);
	c >>=1;  
  }
 System.out.println(chDst); 
b = 18;
b = (b * 0x0202020202 & 0x010884422010) % 1023;
System.out.printn(b);
	}
}
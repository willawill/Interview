public class power2{
	
	public static int power(int x, int y){
		int result=x;
		while (y != 1){
			result *= result;
			y--;
		}
		return result;

	}
	public static int power2( int x , int n )
   {
   int bitMask = n;
   int evenPower = x;
   int result;
   if ( (bitMask & 1) != 0 )
      {
         result = x;
      }
   else
      {
      result = 1;
      }
   bitMask >>>= 1;
	
   while ( bitMask != 0 )
      {
         System.out.println(bitMask);
         evenPower *= evenPower;
      if ( (bitMask & 1) != 0 )
         {
            result *= evenPower;
         }
      bitMask >>>= 1;
	
      } // end while
   return result;
   } // end power

	public static void main(String[] args){
		long start = System.nanoTime();
	
	//	System.out.println(power2.power2(5,4));
		long end = System.nanoTime();
		int sum1= 9;int sum2 = 5;
      int result = 0;
      int c = 0;
      while (true){
         c = (sum1 & sum2);
         System.out.println(c);
         sum1 = sum1^sum2;

         sum2 = c << 1;
         System.out.println(sum1 + "!!"+sum2);
         if (c == 0){break;}
      }
      System.out.println(sum1^sum2);
   }
}
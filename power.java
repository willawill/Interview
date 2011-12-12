//Doboule x, int y.
import java.math.*;


public class power{

public static double power( double x , int n )
   {
   int bitMask = n;
   double evenPower = x;
   double result;
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
      evenPower *= evenPower;
      if ( (bitMask & 1) != 0 )
         {
         result *= evenPower;
         }
      bitMask >>>= 1;
	
      } // end while
   return result;
   } // end power

public static int bitLog( int n )
   {
   if ( n <= 8 )
      {
      return 2 * n;
      }
   else
      {
      int b = 31;
      while ( b > 2 && n > 0 )
         {
         b--;
         n <<= 1;
         }
      n &= 0x70000000;
      n >>= 28;
      return n + 8 *( b - 1 );
      }
   } // end bitLog
public static double root(double num, double x){
	int radix = (int)(1/x);
	System.out.println(radix);
	double result = 1.0;
	double pow = result;
	double r = pow/result;
	double error = pow - num;
	double p = r * radix;
	double eps = 4.5e-6;
	while(Math.abs(error)>eps){
		result = result-error/p;
		pow = result;
		int k=1;
		while(k<radix){
		pow*=result;
		k++;

}
	r=pow/result;
	error =pow-num;
	p=r*radix;

}
return result;
}
	public static void main(String[] args){
	System.out.println(power.power(-5,2));
	System.out.println(power.root(5, 0.5));
}
}



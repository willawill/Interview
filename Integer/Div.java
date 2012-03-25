public class Div{
	
	public static int div(int dividend, int divisor) {
        boolean sameSign = true;
        if ((dividend > 0 && divisor< 0 )||(dividend < 0 && divisor > 0))
            {
                sameSign = false;
            
            }
       
        
        if (divisor == 0) return Integer.MIN_VALUE;
    	int ans = 0;
		for (int i = 32;i >= 0;i--){
			
			if ((dividend >> i) >= divisor){
				ans += (1 << i);
				dividend = dividend - (divisor<<i);
			}
		}
		return sameSign ? ans:-ans;
    }



	public static void main(String[] args){
		System.out.println(Div.div(-2147483647,1));
		System.out.println(Integer.toString(-2147483648,2));
	}
}
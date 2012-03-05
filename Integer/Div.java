public class Div{
	
	public static int div(int x, int y){
		if (y ==0) return -1;
		int ans = 0;
		for (int i = 32;i>0;i--){
			//Since every right shift is dividing the num with some powers of 2.
			if ((x>>i) >= y){
				System.out.println(i);
				ans += (1<<i);
				x = x - (y<<i);
			}
		}
		return ans;
	}
	public static void main(String[] args){
		System.out.println(Div.div(135,3));
	}
}
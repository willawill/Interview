public class Div{
	
	public static int div(int x, int y){
		if (y == 0) return -1;
		int ans = 0;
		for (int i = 31; i >= 0;i--){
		if ((x>>i) != 0){	
		System.out.println((x>>i) + "!!!"+ i);}

			if ((x>>i)>=y){

				ans += (1<<i);
				System.out.println(ans);
				x -= (y<<i);
				System.out.println("The" + (y<<i));
			}

		}
		return ans;
			}

	public static void main(String[] args){
		//System.out.println(Div.div(15, 3));
		System.out.println(5<<2);
		System.out.println(Integer.toString(3>>1,2));
	}
}

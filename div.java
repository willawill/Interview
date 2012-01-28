public class Div{
	
	public static int div(int x, int y){
		if (y == 0) return;
		int ans = 0;
		for (int i = 31; i >= 0;i++){
			if ((x>>i)>=y){
				ans += (1<<i);
				System.out.println(ans);
				x -= (y<<i);
			}
		}
		return ans;
			}

	public static void main(String[] args){
		System.out.println(div.div(15, 3));

	}
}
public class SameBit{
	
	public static int getNext(int num){
		if (num < Integer.MIN_VALUE || num>Integer.MAX_VALUE){
			return -1;
		}
		else{
			int x = Math.abs(num);
			int c1 = 0;
			int c0 = 0;
			int p = 0;
			while (x > 0 && (x & 1) == 0){
				c0++;
				x >>= 1;
			}
			while (( x & 1)==1){
				c1++;
				x >>= 1;
			}
			p = c0+c1;
			if (p == 31||p == 0){
				return -1;
			}
			num = (1<<p)|num; 
			num = num & ((~0) << p);
			num = num|(1 << c1-1)-1;
			return num;
		}
	}
	public static int getPrev(int num){
		if (num < Integer.MIN_VALUE || num>Integer.MAX_VALUE){
			return -1;
		}
		else{
			int x = Math.abs(num);
			int c1 = 0;
			int c0 = 0;
			int p = 0;
			while (x !=0 && (x&1)==1){
				c1++;
				x >>=1;
			}
			while ((x &1) ==0){
				c0++;
				x >>= 1;
			}
			p = c0+c1;
			if (p == 31||p==0)
				return -1;
			num &= ((1 << p)-1);
			num &= (~0) << p;
			num |= ((1 << c1+1)-1)<<(c0-1);
			return num;
	}
}
	public static void main(String[] args){
		System.out.println(SameBit.getNext(9));
		System.out.println(SameBit.getPrev(9));
	}

}
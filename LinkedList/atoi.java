public class atoi{
	
	public static int atoi(String s){
		if (s == null|| s.trim().length() == 0){
			throw new NullPointerException("!!");
		}
		char[] s1 = s.trim().toCharArray();
		int start = 0;
		int result = 0;
		boolean isNeg = false;
		if (s1[start] == '-' || s1[start] == '+'){
			if (s1[start] == '-'){
				isNeg = true;
				start ++;
		}
	}	
	int len = s1.length;
		for (;start<len;start ++){
			if (s1[start] < '0'||s1[start] > '9'){
				throw new IllegalArgumentException("!!!");
			}
			else{
				char digit = (char)(s1[start] - '0');
				result += (digit* Math.pow(10, (len-start-1)));
			}
		}
		if (isNeg){
			return 0-result;
		}
		else
			return result;

	}

	public static void main(String[] args){
		String s = "12345";
		System.out.println(atoi.atoi(s));
	}
}
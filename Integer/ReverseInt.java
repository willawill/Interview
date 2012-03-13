public class ReverseInt {
    public static int reverse(int x) {
        if (x >= Integer.MAX_VALUE||x <= Integer.MIN_VALUE) return -1;
        String input = Integer.toString(x);
        char[] chars = input.toCharArray();
        int i,j;
        i = (x > 0) ? 0:1;
        j = 0;
        int n = chars.length;
        int newInt = 0;
        while (i < n){
            newInt += (chars[i]-'0') * Math.pow(10,j);
            i++;
            j++;
        }
        
        return (x<0)?(-newInt):newInt;
    }

    public static void main(String[] args){
        System.out.println(ReverseInt.reverse(-120));
    }
}
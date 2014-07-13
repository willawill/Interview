import java.util.Arrays;
public class FindNextPalindrome{
  public String findTheNext(int[] number){
    int length = number.length;
    int mid = length / 2;
    int leftEnd = mid - 1;
    int rightStart = (length % 2 == 1) ? (mid + 1): mid;
    boolean leftSmaller = false;

    while(leftEnd >= 0 && number[leftEnd] == number[rightStart]){
      leftEnd --;
      rightStart ++;
    }
    System.out.println(leftEnd + "and " + rightStart);
    if (leftEnd < 0 || number[leftEnd] < number[rightStart]){
      leftEnd = mid - 1;
      int carry = 1;
      if (length % 2 == 1) {
        number[mid] += carry;
        carry = number[mid] / 10;
        number[mid] = number[mid] % 10;
      }
      else{
        rightStart = mid;
      }
      while(leftEnd >= 0) {
        number[leftEnd] += carry;
        carry = number[leftEnd] / 10;
        number[leftEnd] %= 10;
        number[rightStart] = number[leftEnd];
        rightStart ++;
        leftEnd --;
      }
    }
    else{
      while(leftEnd >= 0){

        number[rightStart] = number[leftEnd];
        rightStart ++;
        leftEnd --;
      }
    }
    return Arrays.toString(number);
  }

  int[] toArray(int num){
    String stringNum= String.valueOf(num);
    int[] arrayNum = new int[stringNum.length()];
    for (int i = 0; i < stringNum.length(); i++){
      arrayNum[i] = stringNum.charAt(i) - '0';
    }
    return arrayNum;
  }

  public static void main(String[] args){
    FindNextPalindrome operator = new FindNextPalindrome();
    int[] num = {1, 1, 2, 3, 5};
    System.out.println(operator.findTheNext(num));
  }
}

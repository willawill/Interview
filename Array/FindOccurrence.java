import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindOccurrence {
//	public static final String EXAMPLE_TEST = "(212)5422222" + "John 333-4445555";
	public static final String TEST = "aaacccccccbbbbb";
	public static void main(String[] args) {
		String A = "a+";
		Pattern pattern = Pattern.compile(A);
		Matcher matcher = pattern.matcher(TEST);
		int start = 0;
		int end = 0;
		String find = "";

		if (matcher.find()){
			find = matcher.group();
			start = matcher.start();
			end = start + find.length()-1;
		}
		
		System.out.println(start +" " + end);
	}
}

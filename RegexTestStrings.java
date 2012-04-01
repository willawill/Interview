import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestStrings {
	public static final String EXAMPLE_TEST = "(212)5422222" + "John 333-4445555";

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\(?(\\d{3})\\)?[-. ]?(\\d{3})[-. ]?(\\d{4})");
		Matcher matcher = pattern.matcher(EXAMPLE_TEST);
		
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			System.out.println(matcher.group());
		}
	}
}

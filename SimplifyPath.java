import java.util.*;
public class SimplifyPath {
    public static String simplify(String path) {
        String[] segs = path.split("/");

        Deque<String> d = new ArrayDeque<String>();
        
        for (String seg : segs) {
            System.out.println(seg);
            if (".".equals(seg) || "".equals(seg)) {
                continue;
            }
            else if ("..".equals(seg)) {
                if (!d.isEmpty()) d.removeLast();
            }
            else { 
                d.addLast(seg);
            }
        }
        
        StringBuilder builder = new StringBuilder();
        while (!d.isEmpty()) {
            builder.append("/" + d.pollFirst());
        }
        builder.append("/");
        
        return builder.toString().length()==0? "/" : builder.toString();
    }

    public static void main(String[] args){
        String a = "/a//c/c/s/d/f/e/../f/";
        System.out.println(simplify(a));
    }
}

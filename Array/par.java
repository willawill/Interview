import java.util.*;
public class par{
    private ArrayList<String> result = new ArrayList<String>();

public  void par(int n, int open, int closed, String str) {
 
        if (closed == n) {
            result.add(str);
        }
 
        if (open < n) {
            par(n, open+1, closed, str + "(");
        }
 
        if (closed < open) {
            par(n, open, closed+1, str + ")");
        }
    }
    public  void print(){
        for (String s:result){
            System.out.println(s);
        }
    }
 
    public static void main(String[] args) throws Exception {
        par p = new par();
        p.par(1, 0, 0, "");
        p.print();
 
    }
    }
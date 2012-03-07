import java.util.*;

public class Main {

    public static void main(String[] args) {

        HashMap<String,String> map = new HashMap<String,String>();
        ValueComparator bvc =  new ValueComparator(map);
        TreeMap<String,String> sorted_map = new TreeMap(bvc);

        map.put("A","1S");
        map.put("B","2E");
        map.put("C","2S");
        map.put("D","5E");
        
        System.out.println("unsorted map");
        for (String key : map.keySet()) {
            System.out.println("key/value: " + key + "/"+map.get(key));
        }

        sorted_map.putAll(map);

        System.out.println("results");
        for (String key : sorted_map.keySet()) {
            System.out.println("key/value: " + key + "/"+sorted_map.get(key));
        }
    }

}

class ValueComparator implements Comparator {

  Map base;
  public ValueComparator(Map base) {
      this.base = base;
  }

  public int compare(Object a, Object b) {
    char[] ac = ((String)a).toCharArray();
    char[] bc = ((String)b).toCharArray();
    
    if(ac[0] < bc[0]||((ac[0]==bc[0])&& (ac[1]=='E') && (bc[1] =='S'))) {
      return 1;
    } else if(ac[0]== bc[0] && ac[1] == bc[1]) {
      return 0;
    } else {
      return -1;
    }
  }
}
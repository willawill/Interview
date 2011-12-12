import java.util.ArrayList;  
import java.util.HashSet;  
  
public class Find {  
  
    // 用于存储hash后的数组长度  
    private static int num = 1 << 24;  
  
    // 用hashMap的算法  
    public static int hash(Object obj) {  
        int hash = obj.hashCode();  
        hash += ~(hash << 9);  
        hash ^= (hash >>> 14);  
        hash += (hash << 4);  
        hash ^= (hash >>> 10);  
        hash = hash & (num - 1);  
        return hash;  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
  
        HashSet intersection = new HashSet();  
  
        // 准备要比较的数组个数  
        int seed = 10;  
        int[] s = new int[seed];  
        int[] s2 = new int[seed];  
        int[] hash = new int[num + 1];  
        for (int k = 0; k < seed; k++) {  
            s[k] = (int) Math.round(Math.random() * seed);  
        }  
        for (int k = 0; k < seed; k++) {  
            s2[k] = (int) Math.round(Math.random() * seed);  
        }  
  
        System.out.println("start....");  
        long start3 = System.nanoTime();  
        int size = 0;  
        // hash方法 简单一点线性探测解决冲突问题  
        for (int k = 0; k < seed; k++) {  
            int index = hash(s[k]);  
            int step = 0;  
            while (hash[index] != 0) {  
                index = index + 1;  
                ++step;  
                if (index < num && hash[index] == 0) {  
                    hash[index] = s[k];  
                    break;  
                } else if (index > num) {  
                    step = 0;  
                    index = 0;  
                }  
            }  
            if (hash[index] == 0) {  
                hash[index] = s[k];  
            }  
        }  
        System.out.println("check...");  
        // 检测  
        for (int k = 0; k < seed; k++) {  
            int index = hash(s2[k]); 
            int step = 0;
            while (true) {  
                if (index < num) {  
                    if (hash[index] == 0) //shuo ming zhe li mei you shu.
                        break;  
                    if (hash[index] == s2[k]) {  
                        intersection.add(s2[k]);// 数量级为1000w时不能用hashset了，会out, 改用整数size计数  
                        size++;  
                        break;  
                    }  
                } else if (index > num) {  
                    step = 0;  
                    index = 0;  
                }  
                index = index + 1;  
                ++step;  
            }  
        }  
  
        long end3 = System.nanoTime();  
        System.out.println("hash求合集方法用时:" + (end3 - start3)/1000 + "微秒");  
        System.out.println("合集个数" + intersection.size());  
         
  
        // 加入arraylist后再比较  
        intersection.clear();  
        long start2 = System.nanoTime();  
        ArrayList<Integer> list1 = new ArrayList<Integer>();  
        for (int i = 0; i < seed; i++) {  
            list1.add(s[i]);  
        }  
        for (int i = 0; i < seed; i++) {  
            if (list1.contains(s2[i])) {  
                intersection.add(s2[i]);  
            }  
        }  
        long end2 = System.nanoTime();  
        System.out.println("arryList求合集用时:" + (end2 - start2) / 1000 + "微秒");  
        System.out.println("合集个数" + intersection.size());  
  
        // 双循环数组比较  
        intersection.clear();  
        long start = System.nanoTime();  
        for (int i = 0; i < s.length; i++) {  
            for (int k = 0; k < s2.length; k++) {  
                if (s[i] == s2[k]) {  
                    intersection.add(s2[k]);  
                    break;  
                }  
            }  
        }  
        long end = System.nanoTime();  
        System.out.println("数组循环比较用时:" + (end - start) / 1000 + "微秒");  
        System.out.println("合集个数" + intersection.size());  
  
    }  

}

import java.util.HashMap;
 
public class BetterFindMost {
 
    public static String findSubString(char[] targetList, String targetStr) {
 
        // 异常情况直接返回
        if (targetList == null || targetStr == null || targetList.length == 0
                || targetStr.length() == 0) {
            return null;
        }
 
        // 构造targetList字典表
        HashMap<Character, Integer> mapDic = new HashMap<Character, Integer>();
 
        for (char c : targetList) {
            mapDic.put(c, 0);
        }
        // 字典表也就是targetList的不同目标的累积长度的完成量
        int finished = 0;
 
        // 对应的起始位置
        int mostStart = 0;
        // 对应的终止位置
        int mostEnd = 0;
 
        // 正在进行的轮次子串起始位置
        int curStart = 0;
        // 正在进行的轮次子串终止位置
        int curEnd = 0;
 
        // 初始游标pos遍历targetStr
        for (int pos = 0; pos <targetStr.length(); pos++) {
 
            // 当前游标所指字符
            char posChar = targetStr.charAt(pos);
 
            if (mapDic.get(posChar) == null) {
                continue;
            } else if (mapDic.get(posChar) == 0) {
                //登记起点
                if (finished == 0) {
                    curStart = pos;
                }
                //计数
                mapDic.put(posChar, 1);
                //任务完成量+1
                finished++;
            } else {
                //对应计数+1
                mapDic.put(posChar, mapDic.get(posChar) + 1);
            }
 
            //检查字串头部游标是否可以向前进，在不降低任务完成量下，缩短长度
            char startChar = targetStr.charAt(curStart);
            while (mapDic.get(startChar) == null || mapDic.get(startChar) > 1) {
                if (mapDic.get(startChar) != null) {
                    mapDic.put(startChar, mapDic.get(startChar) - 1);
                }
                curStart++;
                startChar = targetStr.charAt(curStart);
            }
 
            //登记当前轮次解，比较得出当前最优解，同时头部迁移，已完成任务量-1，继续找下一个满足条件
            if (finished == mapDic.size()) {
                //登记结尾
                curEnd = pos + 1;
                //System.out.println(targetStr.substring(curStart, curEnd));
 
                if (((mostEnd - mostStart) == 0)
                        || ((curEnd - curStart) <(mostEnd - mostStart))) {
                    mostStart = curStart;
                    mostEnd = curEnd;
                }
                mapDic.put(targetStr.charAt(curStart), 0);
                curStart++;
                finished--;
            }
 
        }
         System.out.println(mostEnd);
           
        // 如果能找到，则返回结果
        if ((mostEnd - mostStart) != 0) {
            return targetStr.substring(mostStart, mostEnd);
        }
        return null;
    }
    public static void main(String[] args){
        String a = "abskdfjksjflksjlcddd";
        String b = "abd";
        System.out.println(BetterFindMost.findSubString(b.toCharArray(), a));

    }

}
package hash;

import java.nio.channels.CompletionHandler;
import java.util.HashMap;
import java.util.Map;

/**
 *  力扣389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 *
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 *
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 *
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 */
public class FindDifference {
    /**
     * 用一个int[] cnt 数组记录s中每个字符出现的次数
     * 初始化长度26，表示26个英文字母。下标0-25分别表示a-z
     * 存入s中某个字符，就在cnt 对应下标+1.遍历完成就记录了s里的字符出现次数
     * t的中的某个字符出现在cnt里，就cnt[i]--,表示t中的字符在s中出现过
     * 遍历完毕后发现某个字符计数是负的，就说明此字符在t字符串中出现的次数大于s字符串。
     * @return
     */
    public static char findTheDifference(String s, String t) {
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            count[ch-'a']++;
        }
        for(int j=0;j<t.length();j++){
            char ch=t.charAt(j);
            count[ch-'a']--;
            if(count[ch-'a']<0){
                return ch;
            }
        }
        return ' ';
    }

    /**
     * 思路二：用hashMap存储字符出现的频率。
     * 在s中+1，在t中-1.
     * 2中情况：
     *   t中的某个字符次数大于s的。或者 t中右在s中没有
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference2(String s, String t) {
        Map<Character,Integer> mm=new HashMap<>();
        for (Character cc:s.toCharArray()){
            if(mm.containsKey(cc)){
                int cnt=mm.get(cc)+1;
                mm.put(cc,cnt);
                continue;
            }
            mm.put( cc ,1);
        }
        for(Character tt:t.toCharArray()){
            if(!mm.containsKey(tt)){
                return tt;
            }
            if(mm.get(tt)==0){
                return tt;
            }
            int cnt=mm.get(tt)-1;
            mm.put(tt,cnt);
        }
        return ' ';
    }

    /**
     * 用两个变量ssum，tsum记录s和t字符的ASCII码的和
     * 把其差值转换程char就是t中多余字符
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference3(String s, String t) {
        int  sSum=0;
        int  tS=0;
        for(Character ccss:s.toCharArray()){
            sSum+=ccss;
        }
        for(Character cctt:t.toCharArray()){
            tS+=cctt;
        }
        return (char)(tS-sSum);
    }

    /**
     * 异或满足交换率。相同异或为0不同异或为1
     * 1^0=1 0^0=0 任何数和0异或结果为任何数。
     * a^b^c^c^a^c^d=(a^a)^(b^b)^(c^c)^d=d
     * 如果s和t的每个字符相同，那异或的结果为0
     * 如果t比s多一个字符，那么异或结果就是多的那个字符
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference4(String s, String t) {
        int result=0;
        for(Character cc:s.toCharArray()){
            result ^=cc;
        }
        for(Character tt:t.toCharArray()){
            result ^=tt;
        }
        return (char) result;
    }
    public static void main(String[] args) {
        String s1= "abcd";
        String s2="abcde";
        System.out.println(findTheDifference2(s1,s2));
        System.out.println(findTheDifference3(s1,s2));
    }
}

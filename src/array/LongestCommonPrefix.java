package array;


/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class LongestCommonPrefix {

    /**
    * Description:  思路 for循环取出每个字符串
     * 找出这些字符串中长度最小的一个 minLen
     * 取出每个字符串的首字母 比较  。比较minLen次
    * @author: 周都
    * @date: 2021/8/4 15:01
    */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length ==0 || strs == null) {
            return "";
        }
        // 把strs中每个字符串取出来，比较。
        // 假设strs[0]是公共部分
        // 让common和strs[1]比较取出公共部分 common
        // common再和strs[2]比较 取出公共部分 赋值common
        int strsLength = strs.length;
        String common = strs[0];
        // 外层循环控制比较次数 若strsLength=5 只需比较4次
        // 所以从1开始计数
        for(int i=1 ; i<strsLength; i++) {
            int j=0; //记录每个字符串的下标
            for(;j < common.length() && j < strs[i].length(); j++){
                if(common.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            common = common.substring(0,j);
            if(common.equals("")) {
                return "";
            }
        }
        return common;
    }
    public static void main(String[] as) {
        String[] strs  = {"flower","flow","flight"};
        String common = longestCommonPrefix(strs);
        System.out.println(common);
    }
}

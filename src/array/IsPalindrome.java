package array;

import java.util.HashSet;

/**
 * 力扣T 125
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符
 * ，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * @Author 周都
 * @Date 2021/6/11 0:20
 */
public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                builder.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder build22 = new StringBuilder(builder).reverse();
        return build22.toString().equals(builder.toString());
    }

    public static void main(String[] args) {
        char[] ch1= {'a','b','c'};
        System.out.println(ch1[0]>97);
        System.out.println("=============================");
        String arr = "race a car";
        System.out.println(isPalindrome(arr));
    }
}

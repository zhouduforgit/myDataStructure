package classicalalgorithm;

import java.util.HashMap;

/**
 * @Description TODO
    *https://leetcode-cn.com/problems/roman-to-integer/
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。
 * 但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 * 这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

 *
 * 示例 1:
 * 输入: "III"
 * 输出: 3

 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 *
 * 示例 3:
 * 输入: "IX"
 * 输出: 9
 *
 * 示例 4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 *
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 */
public class RomanToInt {

    /**
     * Description: 思路先用hashMap存储数字和字符的对应关系
     * 关键数字组合一般情况 大的在左边小的在右边
     *   VI--->6  ; XV---->15
     *
     * @author: 周都
     * @date: 2021/7/16 12:20
     * @param:
     * @return:
     */
    public static int romanToInt(String s) {
        HashMap<String, Integer> hashMap = new HashMap();
        hashMap.put("I",1);
        hashMap.put("IV",4);
        hashMap.put("V",5);
        hashMap.put("IX",9);
        hashMap.put("X",10);
        hashMap.put("XL",40);
        hashMap.put("L",50);
        hashMap.put("XC",90);
        hashMap.put("C",100);
        hashMap.put("CD",400);
        hashMap.put("D",500);
        hashMap.put("CM",900);
        hashMap.put("M",1000);
        int result =0;
        for (int i = 0; i <s.length() ; ) {
            if(i<s.length()-1 && hashMap.containsKey(s.substring(i,i+2))){
                result += hashMap.get(s.substring(i,i+2));
                i=i+2;
            }else {
                result += hashMap.get(s.substring(i,i+1));
                i++;
            }
        }
        return result;
    }

    /**
    * Description: 用switch case语法代替hashMap存储 罗马字符和数字的关系
     * 正常情况大的在小的左边VI=5+1  LX=50+10
     * 特殊情况小的在大的左边 IV=5-1 IX=10-1 CD=500-100
     * 总之当前位比下一位小  就-，反之+
    * @author: 周都
    */
    public static int romanToInt2(String sss) {
        char[] ch = sss.toCharArray();
        int sum =0;
        // 前一个值初始是index=0的罗马字符对应的int值，
        // 一轮for循环后把preV的下一个赋值给preV,
       for(int i=0; i <ch.length-1; i++) {
           if(getValue(ch[i]) <getValue(ch[i+1])) {
               sum -= getValue(ch[i]);
           }else {
               sum += getValue(ch[i]);
           }
           sum += getValue(ch[ch.length-1]);
       }
       return sum;
    }
    public static int getValue(char ccc) {
        switch(ccc){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }
    public static void main(String[] args) {
        String cd = "CMDXIIC";
        String df ="DIVCML";
        System.out.println(romanToInt(cd));
        System.out.println(romanToInt2(cd));
        System.out.println(romanToInt(df));
    }
}

package classicalalgorithm;

import java.util.Random;

/**
 * @Description TODO
 * @Author 周都
 * @Date 2021/10/13 21:29
 */
public class SortRandom {
    public static void main(String[] args) {
        String result = toSort(20);
        System.out.println(result);
    }
    public static String toSort(int length) {
        // 首先创建固定的字符串
        String strA = "abcdrfghijkmnopqrstuvwxyz23456789";
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<length; i++) {
            // for循环生成length位的随机数.
            // 生成的随机数的范围在strA的长度下标中间,随机数要在循环里面
            int randomNum = new Random().nextInt(strA.length());
            builder = builder.append(strA.charAt(randomNum));
        }
        return builder.toString();
    }


}

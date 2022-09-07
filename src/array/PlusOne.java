package array;
/*
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。


示例1：

输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。

示例2：
输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。

示例 3：
输入：digits = [0]
输出：[1]

* */
public class PlusOne {
    public static void main(String[] args) {

    }
     public  static int[] plusOne(int[] arr) {
        //把数组倒序便利
         //若 最后一位+1后等于10 那么进一【代表原始的最后一位是9】
         // 要arr[i] %10 是否等于0
         //若 最后一位+1不等于10 那么返回arr
         int len = arr.length;
         for (int i = len -1; i >= 0; i--) {
            arr[i]++;
            arr[i] %= 10;
            if(arr[i] != 0) {
                return arr; //arr数组最后一位小于九
            }
         }
         arr = new int[len + 1];
         arr[0] = 1;
         return arr;
     }
}

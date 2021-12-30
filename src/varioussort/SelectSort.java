package varioussort;

import java.util.Arrays;

/**
 * @Description 若默认从小到大排序，最小的数在index=0
 * 选择排序的大概思路是每次for循环找出最小的数 放在第一个位置
 * 第二次循环，从第二个到最后一个，找出最小值放在第二个位置上
 * 若原始数组是 nums = {5,2,8,4,9,1}
 * 第一次  min = 1 ，5和1 换位置
 *   =====》   结果 [1,2,8,4,9,5]
 * 第二次  除1以外for循环 最小值2  [2,8,4,9,5]
 *             结果 [1,2,8,4,9,5]
 * 第三次 除1,2以外  最小值4  [8,4,9,5]  4和8交换
 *             结果 [1,2,4,8,9,5]
 * 第四次 除1,2,4以外 最小值5 [8,9,5]  5和8交换
 *             结果 [1,2,4,5,9,8]
 * 第五次 除1,2,4,5以外  最小值8  [9,8] 9和8交换
 *             结果 [1,2,4,5,8,9]
 */
public class SelectSort {
    /**
    * Description: 思路先找出某次循环中最小值下标
     * 再交换对应的数
    */
    public static int[] selectSort(int[] nums) {
        int minIndex=0;
        // 外层循环是交换的次数
        for(int i = 0; i < nums.length - 1; i++) {
            int smallest = nums[i];
            minIndex = i;
            // 内层循环找出最小值的下标
            for(int j = i + 1; j < nums.length; j++) {
                // 当 i=1 时 j=0 j+1=1
                // 当 i=5 是 j=5 j+1=5
                if (smallest > nums[j]) {
                    smallest = nums[j];
                    minIndex = j;
                }
                // 并让最小值和第i-1个交换
                // 因为每次把最小值放在最前面
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] numm = {66,23,87,62,16};
        int[] vv11 = selectSort(numm);
        System.out.println(Arrays.toString(vv11));


    }
}

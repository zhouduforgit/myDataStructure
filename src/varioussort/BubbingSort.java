/**
 * @Description 此类是分析实现各种排序算法的
 * 冒泡、选择、插入、希尔、快速、合并、基数、堆积树  等排序
 */
package varioussort;

import java.util.Arrays;

/**
 * @Description 此类是冒泡排序
 */
public class BubbingSort {
    /**
    * Description: 思路一 ： 2层for循环
     * 外层是比较的轮次 ，每轮把最小数找出来 一共nums.length - 1 轮
     * 里层是每轮的比较交换的次数
     *  nums = {6,5,9,7,2,8}
     *  第一轮 相邻2个数比较5次 找出2是最小数，把2放在nums末尾 ====》{6,9,7,5,8,2}
     *  第一轮从6个数中找最小 比较5次【相当于6个点用5条线连起来】
     *  第二轮 相邻2个数比较4次 找出5是最小数 把5放在nums末尾 =====》{9,7,6,8,5,2}
     *  经过第一轮最小的数2已在数组nums末尾，只用比较前面5个数了
    */
    public static int[] bubbingSort(int[] nums) {
        for(int i = 1; i <= nums.length-1; i++) {
            for(int j = 0; j < nums.length - i; j++) {
                if(nums[j] < nums[j + 1]) {
                    int temperary = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temperary;
                }
            }
        }
        return nums;
    }

    /**
    * Description: 改进版
     * 内层循环是判断有没有数据交换（默认吧大的放在数组最后）
     * 若某次内循环没有数据交换，说明数组已经排序完成了，无需行进一下次for循环
     * 直接退出外层循环
    */
    public static int[] bubbingSort2(int[] nums) {
        int flag = 0;
        for(int i = 0; i < nums.length; i++) {
            flag = 0;
            for(int j = 0; j < nums.length - 1 -i; j++) {
                if(nums[j+1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = 1;
                }
            }
            if(flag == 0) {
                break;
            }
        }
        return  nums;
    }
    public static void main(String[] args) {
        int[] numss = new int[] {6,5,9,7,2,8};
        int[] newNums = bubbingSort(numss);
        int[] tete2 = bubbingSort2(numss);
        System.out.println(Arrays.toString(newNums));
        System.out.println(Arrays.toString(tete2));
    }
}

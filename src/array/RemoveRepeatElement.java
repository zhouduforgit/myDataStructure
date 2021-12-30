package array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 力扣26
 * 26. 删除排序数组中的重复项
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，
 * 使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1)
 * 额外空间的条件下完成。
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。---->变化后{1,2,2}
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素
 */

public class RemoveRepeatElement {
    public static void main(String[] args) {
        int[] aaaa=new int[] {1,1,2};
        System.out.println(removeDuplicates(aaaa));
    }

    /**
     * 思路1 用快慢双指针 s,f
     * 初始化s=0 ,f=1 。 [0,s]范围内的元素只出现过一次
     * 当 nums[s]==nums[j]时 j++
     * 当 nums[s]!=nums[j]时  s++把原来满指针的向后移动，nums[s]=nums[j] 在此位置附上新元素
     * 让快指针的值和慢指针的值比较，若相等就快指针fast++，  满指针不动
     *                                不相等满指针向前1位，slow++ 。nums[s]=nums[f]。f++
     *  慢指针slow       快指针fast      原数组是
     *      0               1           {1，1，2，3，3，4}
     *      此时 nums[0]=nums[1]=1 ,快指针fast++，  满指针不动
     *      0               2           {1，1，2，3，3，4}
     *      此时nums[0]=1  nums[2]=2,不相等  s++, nums[1]=nums[2]=2, f++
     *      1               3           {1，2，2，3，3，4}
     *      此时nums[1]=2  nums[3]=3,不相等  s++, nums[2]=nums[3]=3, f++
     *      2               4           {1，2，3，3，3，4}
     *      此时nums[2]=3  nums[4]=3 ，相等快指针fast++，  满指针不动
     *      2              5            {1，2，3，3，3，4}
     *      此时nums[2]=3  nums[5]=4 ,不相等  s++, nums[3]=nums[5]=4, f++. f是从5到6
     *      3              6            {1，2，3，4，3，4} 此时f=6 6<nums.length==false 终止循环
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int s=0;
        for(int f=1;f<nums.length;f++){
            if(nums[s]!=nums[f]){
                s++;
                nums[s]=nums[f];
            }
        }
        return s+1;
    }
}

package array;

import java.util.HashSet;

/**
 * @Description  力扣 T 35
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。

 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * @Author 周都
 * @Date 2021/6/7 14:33
 */
public class SearchInsert {
    /**
    * Description: 思路
     * 循环遍历nums 判断nums[i] == target
     * if true  返回i
     * if (nums[i] < target nums[i+1]) return i+1； i指向倒数第二个 nums.length-2
     *
     *
    * @author: 周都
    * @date: 2021/6/7 14:39
    * @param:
    * @return:
    */
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for (int i=0;i<len;i++) {
            if(nums[i] == target){
                return i;
            }
            if((i>=0&&i<len-1) && nums[i]< target && nums[i+1]>target){
                return i+1;
            }
            if(target> nums[len-1]){
                return nums.length;
            }
            if(target<nums[0]){
                return 0;
            }
        }
        return -1;
    }
}

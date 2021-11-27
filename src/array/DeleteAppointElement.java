package array;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，
 * 你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2,
 * 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
 * 例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。

 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5,
 * 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 */

public class DeleteAppointElement {
    /**
     *  思路 1 发现第i个元素==指定数val
     *  就把数组中最后一个元素赋给当前元素nums[i] 数组长度-1
     *  若  nums[i]!=val i++。对撞指针i和len
     *  {5,4,4,2,1}  val=4
     *   i   nums[i]                             len       数组
     *   0      5     5!=4 i++                    5      {5，4，4，2，1}
     *   1      4     4=4 nums[i]=nums[len-1]=1   4      {5，1，4，2}       把当前第i(1)个元素换成倒数第一个元素1  len--
     *   2      4     4=4 nums[i]=nums[len-1]=2   3      {5,1,2}  把当前第i(2)个元素换成倒数第一个元素2  len--
     *   结束条件 i<len  此时i=2  小于len3  此时nums[2]=2!=4 i++   ----> i=3
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int len=nums.length;
        int i=0;
        while(i<len){
            if(nums[i]!=val){
                nums[i]=nums[len-1];
                len--;
            }else {
                i++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] aaa=new int[]{5,4,4,2,3,1};
        System.out.println(removeElement(aaa,4));
    }
}

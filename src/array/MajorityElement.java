package array;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 力扣 T169
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class MajorityElement {
    /**
     * 用hashMap存储数组中元素出现的次数
     * key--->是数组中的元素nums[i]
     * value----->出现次数  int count=hashMap.get(num);
     * 当count>n/2----> return num
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int num:nums){
            if(hashMap.containsKey(num)){
                hashMap.put(num,hashMap.get(num)+1);
            }else {
                hashMap.put(num,1);
            }
            int count=hashMap.get(num);
            if(count>nums.length/2){
                return num;
            }
        }
       return -1;
    }

    /**
     * 先排序再取出索引n/2的元素
     *   原数组              新数组           中位数
     *  {2,2,1,1,1,2,2}    {1,1,1,2,2,2,2}      2
     *  {1,2,1,1}           {1,1,1,2}           1
     * @param nums
     * @return
     */
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int length=nums.length;
        return nums[length/2];
    }

    /**
     * 多数元素的个数一定比其它元素个数总和多
     * 可以类比投票机制
     * 规则 ：选择nums[0]作为候选人 出现一个相同的元素 次数+1；出现一个不相同的元素 次数-1
     * 最后候选人的投票数>0
     * 原数组 {{2,2,1,1,1,2,2}
     *  元素          出现次数        候选人
     *   2               1              2
     *   2               2              2
     *   1               1              2
     *   1               0              1  次数是0时重置候选人
     *   1               1              1
     *   2               0              2  次数是0时重置候选人
     *   2               1              2
     * @param nums
     * @return
     */
    public static int majorityElement3(int[] nums){
        int candidate = 0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            //次数是0时重置候选人
            if(count==0){
                candidate=nums[i];
            }
            if(candidate==nums[i]){
                count++;
            }else {
                count--;
            }
        }
        return candidate;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement1(nums));

        int[] nums2=new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement3(nums2));
    }
}

package queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class SlidingWindow {
    /**
     * 思路
     * 数组长度len=nums.length,所以窗口的个数是len-k+1个
     * 当下标在i~[0,k)时，是未形成窗口阶段
     * 重点考虑已经有窗口形成的阶段  创建ArrayDeque记录当前窗口的最大值
     * 创建数组res存储每个窗口的最大值
     *   窗口            maxDeque
     * [1  3  -1]    [1]-->[3]-->[3,-1]
     * [3  -1  -3]   [3,-1,-3]
     * [-1  -3  5]   [5] 3退出了窗口还剩-1，-3，新进来的5>maxDeque中每个元素就覆盖
     * [-3  5  3]    [5,3]
     * [5  3  6]     [6]
     * [3  6  7]     [7]
     * @param nums 是传入的原始数组
     * @param k 是窗口的长度
     * @return 返回所有窗口中的最大值组成的数组
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //建数组res来存每个窗口的最大值
        int[] res=new int[nums.length-k+1];
        //建ArrayDeque存当前窗口的最大值，最大值在对头元素
        Deque<Integer> maxDeque=new ArrayDeque<>();
        //未形成窗口阶段
        for(int i=0;i<k;i++){
            while(!maxDeque.isEmpty() && nums[i]>maxDeque.peekLast()){
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[i]);
        }
        //第一个窗口已经形成，把maxDeque的最大值（就是头元素放进res）
        res[0]=maxDeque.peekFirst();
        //已经形成窗口阶段,i下标从k开始
        for(int i=k;i<nums.length;i++){
            System.out.println("这是第"+(i-k+1)+"个窗口");
            //从有第一个窗口开始就元素元素退出maxDeque
            if(nums[i-k]==maxDeque.peekFirst()){
                maxDeque.pollFirst();
            }
            //进对
            while(!maxDeque.isEmpty() && nums[i]>maxDeque.peekLast()){
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[i]);
            res[i-k+1]=maxDeque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] aaa=new int[]{1,3,-1,-3,5,3,6,7};
        int[] res=maxSlidingWindow(aaa,3);
        System.out.println(Arrays.toString(res));
    }
}

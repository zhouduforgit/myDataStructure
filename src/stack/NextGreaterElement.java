package stack;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 .其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
 * 如果不存在，对应位置输出 -1 。
 *
 * 示例 1:
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 */
public class NextGreaterElement {
    /**
     * 思路：用栈存储nums中当前元素的下一个更大元素
     * 若出现了下个更大，就把当前，和下一个存入hashmap。更改栈中元素
     * 如nums2={2, 3, 5, 1, 0, 7, 4}
     * hashMap <2,3> <3,5> <0,7> <1,7> <5,7> <7,-1> <4,-1>
     *     hashMap<Integer,Integer> key是当前值，value是写一个大值
     * stack [2]-->3
     * stack [3]-->5
     * stack [5]-->1
     * stack [5,1]-->0
     * stack [5,1,0]-->7
     * stack [7] -->4
     * stack [7,4]
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //hashMap记录当前值和下一个最大值的的关系
        HashMap<Integer, Integer> hashMap=new HashMap<>();
        //存储nums2的元素后一个大的进来代替前一个，若后一个小存入栈顶
        Stack<Integer> stack=new Stack<>();
        //记录nums1中的一个元素的更大值
        int[] result=new int[nums1.length];
        for(int i=0;i<nums2.length;i++){
            while(!stack.empty() && nums2[i]>stack.peek()){
                hashMap.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }
        //循环完毕stack中的元素没有pop()完全，说明nums1中的元素在nuns2中没有更大值
        while(!stack.empty()){
            hashMap.put(stack.pop(),-1);
        }
        for(int i=0;i<nums1.length;i++){
            result[i]=hashMap.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1=new int[]{2, 3, 5, 1, 0, 7,4} ;
        int[] arr2=new int[]{2, 3, 5, 1, 0, 7, 4};
        int[] res=nextGreaterElement(arr1,arr2);
        System.out.println(Arrays.toString(res));
    }
}

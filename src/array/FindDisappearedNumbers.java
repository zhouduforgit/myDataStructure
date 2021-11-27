package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 力扣 448题
 * 448. 找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，
 * 数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗?
 * 你可以假定返回的数组不算在额外空间内。
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]

 * 输出:
 * [5,6]
 */
public class FindDisappearedNumbers {
    /**
     * 思路1 ：先用hashSet存储原始数组的元素（重复的元素不存入）
     *      for循环 用下标表示对应元素，因为原数组范围[1,n]
     *      for(int i=1;i<=nums.length;i++)
     *      在hashSet中查找i是否存在
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumber1(int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();
        List<Integer> missList=new ArrayList<>();
        for(int num:nums){
            hashSet.add(num);
        }
        for(int i=1;i<=nums.length;i++){
            if(!hashSet.contains(i)){
                missList.add(i);
            }
        }
        return missList;
    }

    /**
     * 原数组  [4,3,2,7,8,2,3,1]   [5,6]
     *         [3,2,2,4,5,1,3,1]   [6,7,8]
     * 因为原数组的范围[1,n]假设元素数组的有有序的
     * 那么元素和其小标有关系   nums[i]=i+1
     *  元素        对应的索引                                 新数组
     *    4       3: 把3号索引的元素改成负数(7--->-7)     {4,3,2,-7,8,2,3,1}
     *    3       2: 把2号索引的元素改成负数(2--->-2)     {4,3,-2,-7,8,2,3,1}
     *    2       1: 把1号索引的元素改成负数(3--->-3)     {4,-3,-2,-7,8,2,3,1}
     *    7       6: 把6号索引的元素改成负数(3--->-3)     {4,-3,-2,-7,8,2,-3,1}
     *    8       7: 把7号索引的元素改成负数(1--->-1)     {4,-3,-2,-7,8,2,-3,-1}
     *    2       1: 已经改过
     *    3       2: 已经改过
     *    1       0: 把0号索引的值改为负数(4--->-4)       {-4,-3,-2,-7,8,2,-3,-1}
     *    此时没有变成负数的索引是4、5，对应的值是5，6。
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumber2(int[] nums) {
        List<Integer> missList=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int num=Math.abs(nums[i]);
            int index=num-1; //元素对应的索引  4--->3
            if(nums[index]>0) {
                nums[index] = -nums[index];
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                missList.add(i+1);
            }
        }
        return missList;
    }

    /**
    * Description:
     旧数组 nums = [4,3,2,7,8,2,3,1]   新数组 newArr = [0,0,0,0,0,0,0,0]
     for循环nums中第一个元素  nums[0] = 4
     把newArr中第4个元素赋值为1    ----->    newArr = [0,0,0,1,0,0,0,0]

     for循环nums中第二个元素  nums[1] = 3
     把newArr中第3个元素赋值为1    ----->    newArr = [0,0,1,1,0,0,0,0]

     for循环nums中第三个元素  nums[2] = 2
     把newArr中第2个元素赋值为1    ----->    newArr = [0,1,1,1,0,0,0,0]

     for循环nums中第四个元素  nums[3] = 7
     把newArr中第7个元素赋值为1    ----->    newArr = [0,1,1,1,0,0,1,0]

     for循环nums中第五个元素  nums[4] = 8
     把newArr中第8个元素赋值为1   把newArr中第2个元素赋值为1

     for循环nums中第六个元素  nums[5] = 2
     把newArr中第2个元素赋值为1，此时newArr的第二个已经赋值，2是nums中重复的元素，newArr不变
     ----->    newArr = [0,1,1,1,0,0,1,1]

     for循环nums中第七个元素  nums[6] = 3
     把newArr中第3个元素赋值为1，此时newArr的第三个已经赋值，2是nums中重复的元素，newArr不变													   ----->    newArr = [0,1,1,1,0,0,1,1]

     for循环nums中第八个元素  nums[7] = 1
     把newArr中第1个元素赋值为1     ----->    newArr = [1,1,1,1,0,0,1,1]
     循环结束后，newArr中第x个位置上元素是0，则x就是旧数组nums中缺失的元素。是第5个和第6个缺失
    */
    public static List<Integer> findDisappearedNumber3(int[] nums) {
        ArrayList<Integer> listResult= new ArrayList<>();
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[nums[i] -1] = 1;
        }
        for(int j =0; j < newArr.length; j++) {
            if(newArr[j] == 0) {
                listResult.add(j+1);
            }
        }
        return listResult;
    }

    public static void main(String[] args) {
        int[] nums1=new int[]{4,3,2,7,8,2,3,1};
        int[] nums2={1,1};
        int[] num33= {4,3,2,7,8,2,3,14,3,2,7,8,2,3,1};
        List<Integer> missList=findDisappearedNumber1(nums2);
        System.out.println(missList);
        List<Integer> missList2=findDisappearedNumber2(nums2);
        System.out.println(missList2);

        List<Integer> missList3=findDisappearedNumber3(num33);
        System.out.println(missList3);
    }
}

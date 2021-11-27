package array;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 力扣  T349
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
public class TwoArrayIntersection {
    /**
     *  思路1：
     *  一次for循环 把nums1数组的元素的值存入hashSet里
     *  第二次for循环 遍历nums2里的元素 ，判断是否在hashSet里
     *  若存在就是此元素是交集元素
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet1=new HashSet<>();
        for(int i=0;i<nums1.length;i++ ){
            hashSet1.add(nums1[i]);
        }
        HashSet<Integer> hashSet2=new HashSet<>();
        for(int j=0;j<nums2.length;j++){
            if(hashSet1.contains(nums2[j])){
                hashSet2.add(nums2[j]);
            }
        }
        int nnn=hashSet2.size();
        int index=0;
        int[] newArr=new int[nnn];
        for(Integer vvv:hashSet2){
            newArr[index]=vvv;
            index++;
        }
        return newArr;
    }

    /**
     *  思路2：用双指针遍历2个数组
     *  首先排序2个数组（从小到大排列）
     *  先取出2个数组中的元素 n1=nums1[i]  n2=nums2[j]
     *  if(n1<n2) 就把n1的下标往后移一位
     *  if(n1>n2) 就把n2的下标往后移一位
     *  if(n1==n2) 就把n1存入新数组
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1=0, index2=0,newIndex=0;
        //创建新数组存储交集 长度是length1 or length2 交集元素个数一定小于任意集合的长度
        int[] newArr=new int[nums1.length]; //新数组的长度length1 可能大于交集元素个数 --->length1>newIndex
        while(index1<nums1.length && index2< nums2.length){
           int nnn1=nums1[index1], nnn2=nums2[index2];
           if(nnn1==nnn2){
               if(newIndex==0 || nnn1!=newArr[newIndex-1]){
                   newArr[newIndex]=nnn1;
                   newIndex++;
               }
               index1++;//找到交集元素时 2个数组下标往后移
               index2++;
           }else if(nnn1>nnn2){
               index2++;
           }else{
               index1++;
           }
        }
        int[] arr2=new int[newIndex];
        for(int i=0; i<newIndex;i++){
            arr2[i]=newArr[i];
        }
        return arr2;
    }


    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        int[] vvv=intersection1(nums1,nums2);
        System.out.println(Arrays.toString(vvv));
        int[] vvv2=intersection1(nums1,nums2);
        System.out.println(Arrays.toString(vvv2));
    }
}

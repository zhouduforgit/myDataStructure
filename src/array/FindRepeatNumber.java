package array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指offer  T 03
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 */
public class FindRepeatNumber {
    /**
     *  思路1：暴力循环法，创建2个下标i,j双层循环
     *  j=i+1开始递增。
     *  假设 nums.length=5
     *  i=0时  j=1,2,3,4
     *  i=1时  j=2,3,4
     *  i=2时  j=3,4
     *  i=3时  j=4
     *  象冒泡排序一样比较，如果nums[i]==nums[j]就返回nums[i]
     * @param nums
     * @return
     */
    public static int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    return nums[i];
            }
        }
        return -1;
    }

    /**
     * 思路2 用hashSet存储数组中的元素，set只能存储不同value的元素
     * 边循环边存储 ，在存储之前判断即将存储的元素是否已经在set里
     * 若以存在返回-1，若不存在就存入hashSet
     * @param nums
     * @return
     */
    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> hashSet=new HashSet();
        for(int num:nums){
            if(hashSet.contains(num)){
                System.out.println("存入这num之前hashSet里已存在："+num);
                return num;
            }
            System.out.println("这个num:"+num+"在hashSet里不存在，可以存入");
            hashSet.add(num);
        }
        System.out.println("数组中没有重复的元素");
        return -1;
    }

    /**
     * 思路3 先把无序的数组变成有序数组
     *  再把有序的元素相邻的两个元素比较
     *  nums[i]和nums[i-1],i是数组下标正常从0开始，不行这样i-1就是-1
     * @param nums
     * @return
     */
    public static int findRepeatNumber3(int[] nums) {
        System.out.println("排序前");
        System.out.println(Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("排序后");
        System.out.println(Arrays.toString(nums));
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1]){
                return nums[i];
            }
        }
        return -1;
    }

    /**
     *  思路四：因为数组长度是n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     *  [0,n-1]刚好是数组下标的范围
     *  新建数组 int[] tem=new int[nums.length]
     *  原数组nums={2, 3, 1, 0, 2, 5, 3}
     *  新数组 tem={0, 0, 0, 0, 0, 0, 0}
     *  循环原数组时往新数组赋值
     *  比如原数组的第一个值是2，就在新数组的2号索引位置的值改为1
     *  出现了重复元素，在新数组中表现为该索引的value不是0
     *  nums[0]=2  -----> tem={0, 0, 1, 0, 0, 0, 0}
     *  nums[1]=2  -----> tem={0, 0, 1, 1, 0, 0, 0}
     *  nums[2]=1  -----> tem={0, 1, 1, 1, 0, 0, 0}
     *  nums[3]=0  -----> tem={1, 1, 1, 1, 0, 0, 0}
     *  nums[4]=2  -----> tem={1, 1, 1, 1, 0, 0, 0}此时4号索引的value=1非0已被占用
     * @param nums
     * @return
     */
    public static int findRepeatNumber4(int[] nums) {
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            //取出原数组索引对应的value
            int value=nums[i];
            //在新数组中以存在原数组的某个value，不用存了，多余了
            if(temp[value]==1){
                return value;
            }
            if(temp[value]==0){
                temp[value]=1;
            }
        }
        return -1;
    }

    /**
     * 思路5： i表示nums数组的下标 让 nums[i]=i。
     * 若下标i对应的value不等于i，就交换位置把value放在对应的索引位置
     * 原数组  nums={2, 3, 1, 0, 2, 5, 3},从左向右遍历
     * nums[0]=2 ,这个2要放在索引是2的位置  nums[2]=1. 就把1和2换位置
     * 原数组就变为： nums={1,3,2,0,2,5,3}
     * nums[0]=1,这个1要放在索引是1的位置   nums[1]=3, 就把3和1换位置
     * 原数组就变为： nums={3,1,2,0,2,5,3}
     * nums[0]=3,这个3要放在索引是3的位置   nums[3]=0, 就把0和3换位置
     * 原数组就变为： nums={0,1,2,3,2,5,3}
     * 若满足索引i和value相等，往后遍历。出现不相等再判断，如果下一个value（2）在对应索引位置上出现过
     * 就表是这个value重复了
     * @param nums
     * @return
     */
    public static int findRepeatNumber5(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int value=nums[i];   //第一次循环 value=nums[0]=2
            if(value==i) continue;
            if(nums[value]==value){
                return value;
            }
            if(value!=i){
                int tem=-1;
                tem=nums[value];  //tem=nums[2]=1
                nums[i]=tem;      //以前的nums[0]=2 ;now的nums[0]=1
                nums[value]=value;//以前的nums[2]=1   ;now的 nums[2]=2
                i--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nnn=new int[]{2, 3, 1, 0, 2, 5, 3};
        int vvv=findRepeatNumber1(nnn);
        System.out.println(vvv);

        System.out.println("=====================");

        System.out.println(findRepeatNumber2(nnn));

        System.out.println("=====================");
        System.out.println(findRepeatNumber3(nnn));

        System.out.println("=====================");
        int[] nnn4=new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber4(nnn4));

        System.out.println("=================");
        int[] nnn5=new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber5(nnn5));
    }
}

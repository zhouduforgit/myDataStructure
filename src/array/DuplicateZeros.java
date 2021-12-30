package array;

import java.util.Arrays;

/**
 * @Description TODO
 * 力扣 1089
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，
 * 并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组就地进行上述修改，不要从函数返回任何东西。

 * 示例 1：
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 *
 * 示例 2：
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]

 * @Author 周都
 * @Date 2021/5/17 10:05
 */
public class DuplicateZeros {
    /**
    * Description:  思路先遍历原始数组arr记录0出现的位置
     * 创建一个新数组arr2 其长度是原来2倍
     * 当arr[i]=0时  让arr2[i]=arr2[i+1]=0 ,并且让arr中i+1以后的所有元素复制到arr2[i+2]的后面
    * @author: 周都
    * @date: 2021/5/17 10:10
    * @param:
    * @return:
    */


    public static void duplicateZeros(int[] arr) {
        int [] num = new int [arr.length];
        int [] arrcopy = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            //赋值一个与原数组一样的数组
            arrcopy[i] = arr[i];
        }
        int dis = 0;
        for (int i = 0; i < arr.length; i++){
            //记录因为0的出现，导致的每一个元素应该偏移的量dis，记录于num数组。
            if (arr[i] == 0){
                dis++;
            }
            num[i] = dis;
        }
        //如果没有0，直接返回了
        if (dis==0) {
            return;
        }
        //初始化原数组，置为0
        for (int i = 0; i < arr.length; i++){
            arr[i] = 0;
        }
        //偏移量作用
        for (int i = 0; i + num[i] < arr.length; i++){
            arr[i+num[i]] = arrcopy[i];
        }
    }
}

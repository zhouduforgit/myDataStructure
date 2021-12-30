package varioussort;

import java.util.Arrays;

/**
 * @Description TODO
 *  插入排序可以吧原数组看成2个数组
 *  一个是左边一排好的，另一是右边未拍好的
 *  若 原数组是{8,4,6,73,5,47}
 *  8 （有序）   4,6,73,5,47（无序） 让无序数组的第一个和有序数组的最后一个比较   4<8
 *  4,8 (有序)   6,73,5,47    4 <6 <8  此时6插入到4和8中间 ， 8要往后后移一位【4,8,8】，让6移到原来8的位置【下标=1】
 *  4,6,8      73,5,47       8<73  此时73直接放在有序数组的最后一个
 *  4,6,8,73      5,47    5<6<8<73 && 5>4  5要插入在4和6中间  ，所以6,8,73要往后移一位，为5腾出位置，让5放在原来6的位置
 *  4,5,6,8,83     47     8<47<83  83要往后一位。让原来83位置变成47
 *  4,5,6,8,47,83
 */
public class InsertSort {
    public static int[]  insertSort(int[] numss) {
        // 插入排序 默认从小 到大排序
        for(int i = 0; i < numss.length; i++) {
            int temp = numss[i];
            int j = i - 1;
            while(j >= 0 && temp < numss[j]) {
                // 若后一个比前一个小
                // 就把前一个的内容移到后一个，整体向后移
                numss[j + 1] =numss[j];
                j--;
            }
            numss[j + 1] = temp;
        }
        return numss;
    }
    public static void main(String[] args) {
        int[] nunss = new int[]{8,4,6,73,5,47};
        int[] vvv = insertSort(nunss);
        System.out.println(Arrays.toString(vvv));
        int[] nunss22 = new int[]{8,4,6,7,15,3,5,47};
        int[] vvv22 = insertSort(nunss22);
        System.out.println(Arrays.toString(vvv22));
    }
}

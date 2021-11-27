import java.util.Arrays;

/**
* Description:
 *  将两个升序数组合并为一个新的 升序 数组并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *  输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 */
public class MergeTwoArr {
    /**
    * 思路1 ：先考虑2个数组长度相等的情况
     * 假设以l1位基准 ，把l2中的元素移到l1中
     * 新建数组mergeArr[] 存储合并以后的数组  长度是l1.length+l2.length
     *
    */
    public static int[] mergeTwoLists(int[] l1, int[] l2) {
        //  l2中大于，等于l1中对应位置的放右边，小于放左边
        int l1_len = l1.length;
        int l2_len = l2.length;
        int sumLen = l1_len + l2_len;
        int[] mergeArr = new int[sumLen];
        int j=0;
        if(l1_len > l2_len) {
            for(int i=0; i<l2_len; i++) {
                if(l1[i] <= l2[i]) {
                    mergeArr[j++] = l1[i];
                    mergeArr[j++] = l2[i];
                }else {
                    mergeArr[j++] = l2[i];
                    mergeArr[j++] = l1[i];
                }
            }
            for(int k= 0; k< l1_len-l2_len; k++) {
                System.out.println(l1[l2_len+k]);
                mergeArr[j++] = l1[l2_len+k];
            }
        }

        if(l1_len < l2_len) {
            for(int i=0; i<l1_len; i++) {
                if(l1[i] <= l2[i]) {
                    mergeArr[j++] = l1[i];
                    mergeArr[j++] = l2[i];
                }else {
                    mergeArr[j++] = l2[i];
                    mergeArr[j++] = l1[i];
                }
            }
            for(int k=0; k<l2_len-l1_len; k++) {
                mergeArr[j++] = l2[l1_len+k];
            }
        }
        if(l1_len == l2_len) {
            for(int i=0; i<l1_len; i++) {
                if(l1[i] <= l2[i]) {
                    mergeArr[j++] = l1[i];
                    mergeArr[j++] = l2[i];
                } else {
                    mergeArr[j++] = l2[i];
                    mergeArr[j++] = l1[i];
                }
            }
        }
        return mergeArr;
    }
    public static void main(String[] args) {
        int[] str1 = new int[]{1,2,4,5,9};
        int[] str2 = new int[]{1,3,4};
        int[] merArr = mergeTwoLists(str1,str2);
        System.out.println(Arrays.toString(merArr));
        System.out.println("==================================");

        int[] str3 = new int[]{1,2,4};
        int[] str4 = new int[]{2,3,5,6,8};
        int[] merArr22 = mergeTwoLists(str3,str4);
        System.out.println(Arrays.toString(merArr22));
        System.out.println("======================================");

        int[] str5 = new int[] {1,5,9};
        int[] str6 = new int[] {6,7,8};
        int[] merArr33 = mergeTwoLists(str5,str6);
        System.out.println(Arrays.toString(merArr33));
        System.out.println("======================================");

    }
}
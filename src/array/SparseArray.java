package array;

import java.util.Arrays;

/**
 * 把普通二维数组转换成稀疏数组
 * 假如原二维数组时4*4 int[][] arr=new int[4][4];
 *      0   1   2   3
 *  0   0   0   0   0
 *  1   0   0   1   0
 *  2   0   0   0   2
 *  3   0   0   0   0
 *
 *  先找出二维数组中非0元素,并记录其个数  count=2
 *  再创建稀疏数组sparseArr int[][] sparseArr=int[count+1][3];
 *      0   1   2
 *  0   4   4   2 *  稀疏数组第一行记录 原二维数组 行数 列数  非0元素个数
 *  1   1   2   1    第1个非0元素  在第1行第2列  =1
 *  2   2   3   2    第2个非0元素  在第2行第3列  =2
 */
public class SparseArray {
    public static void main(String[] args) {
        System.out.println(1%10);
        System.out.println(2%10);
        System.out.println(3%10);
        System.out.println(14%10);
    }
}

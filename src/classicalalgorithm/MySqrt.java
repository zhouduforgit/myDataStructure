package classicalalgorithm;

/**
 * @Description
 * 实现int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 4的平方根是2  8的平方根2.828.。。  去掉小数 是2
 * */
public class MySqrt {
    private static int ans;
    /**
    * Description: 思路1 规定左右中三个节点
     * left = 0； right = x;  mid=(left + right)/2
     * 定义 square=mid*mid  若  square > x 【比如当x=9时 mid=4 square=16 ,说明x的平方根3在mid的左边，右边界左移到mid】
     * 若 square < x 【比如x=3时 mid=1 square=1 ,说明x的平方根1.732在mid的右边,左边界移动到mid】
    */

    public static int mySqrt(int x) {
        long left =0;
        long right =x+1;
        while(left < right) {
            long mid = left + right>>1;
            if(check(mid,x)){
                left = mid +1;
            }else{
                right =mid;
            }
        }
        return ans;
    }
    private static boolean check(long mid, int x) {
        if(mid*mid <x && (mid+1)*(mid+1)>x) {
            ans = (int)mid;
            return true;
        }
        if(mid*mid > x){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(mySqrt(7));
     }
}

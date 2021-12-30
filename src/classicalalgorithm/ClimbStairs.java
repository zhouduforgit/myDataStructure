package classicalalgorithm;

/**
 * @Description TODO
 * 经典算法题把楼梯 规定一次只能上1节楼梯或只能上2节楼梯。
 * 问上到第n节楼梯一共有多少种方法
 * @Author 周都
 * @Date 2021/8/31 15:52
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(26));
    }
    public static int climbStairs(int n) {
        if(n==1) {
            return 1;
        }
        if(n==2) {
            return 2;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }
}

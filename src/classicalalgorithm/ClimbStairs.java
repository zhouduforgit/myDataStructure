package classicalalgorithm;

/**
 * @Description TODO
 * @Author 周都
 * @Date 2021/8/31 15:52
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(13));
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

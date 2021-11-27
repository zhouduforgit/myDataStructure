package classicalalgorithm;

import java.util.Scanner;

/**
 * 求阶乘
 */
public class Factorial {
    //求阶乘用暴力的方法
    // 5！=5*4**3*2*1
    public  static int factorial(int n){
        int sum=1;
        for(int i=1;i<=n;i++){
            sum=sum*i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int vvv=factorial(n);
        System.out.println("数字n的阶乘是"+vvv);
    }
}

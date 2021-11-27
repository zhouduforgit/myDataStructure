package classicalalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 斐波那契数列指的是这样一个数列
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，377，610，987，1597，2584
 * 特别指出：第0项是0，第1项是第一个1。
 * 这个数列从第三项开始，每一项都等于前两项之和
 */
public class Fib {
    //用递归法实现斐波那契额数列
    public static void main(String[] args) {
        try {
            BufferedReader buf= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("递归调用斐波那契额数列");
            System.out.println("请输入一个数");
            String str=buf.readLine();
            int num=Integer.parseInt(str);
            if(num<0){
                System.out.println("请输入正整数");
            }else {
                System.out.println("第num位对应的数："+fibonacii2(num));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int fibonacii(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }else{
            //第n项必须是前2项的和
            return fibonacii(n-1)+fibonacii(n-2);
        }
    }

    /**
     * 用迭代的方式代替递归
     * 用数组来存储每层的值
     * @param n 一共有几层 ,n表示数组下标从0开始,最上层用n-1表示
     * @return
     */
    public static int fibonacii2(int n){
        if(n<=1){
            return 1;
        }
        int[] res=new int[n];
        res[0]=1;
        res[1]=1;
        for(int i=2;i<res.length;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n-1];
    }
}

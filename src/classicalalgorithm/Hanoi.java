package classicalalgorithm;

import java.util.Scanner;

/**
 *一、汉诺塔起源
 * 汉诺塔（又称河内塔）问题是源于印度一个古老传说的益智玩具。
 * 大梵天创造世界的时候做了三根金刚石柱子
 * ，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
 * 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
 * 并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
 */
public class Hanoi {
    static int times; //一共走了多少步

    public static void move(int disk,char start,char end){
        System.out.println("第"+(++times)+"次移动盘子"+disk+"  "+start+"----->"+end);
    }
    /**
     * 思路 ：先把前N-1个圆盘 从A移动到B
     *      再把最大的圆盘(第n个)移动到C
     *      再把前n-1个圆盘从B移动到C
     *      定义A,B,C三个圆盘的位置
     * @param n  盘子个数
     * @param A  起点
     * @param B  转接点
     * @param C  终点
     */
    public static void  hanoi(int n, char A, char B, char C){
        if( n== 1){
            move(n,A,C);
        } else{
            //先把前N-1个圆盘 从A移动到B
            hanoi(n-1,A,C,B);
            //把第n个盘子，最大的盘子移动到C
            move(n,A,C);
            //再把B的n-1个盘子移动到C上
            hanoi(n-1,B,A,C);
        }
    }

    public static void main(String[] args) {
        char A='A';
        char B='B';
        char C='C';
        System.out.println("汉若塔游戏开始");
        System.out.println("请输入盘子数");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        hanoi(n,A,B,C);
        sc.close();
    }
}

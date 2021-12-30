package stack;

import javax.swing.*;
import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，
 * 也可以是另一个逆波兰表达式。

 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。
 * 换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。

 * 示例 1：
 * 输入：tokens = ["2","1","+","3","*"]
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 示例 2：
 * 输入：tokens = ["4","13","5","/","+"]
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 * 示例 3：
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class EvalRPN {
    /**
     *  后缀表达式的优先级是从左到右的
     *  出现两个数字push入栈出现运算符就pop出栈，进行运算
     *  第一个pop出栈的元素是在运算符的右边
     *  把运算结果重新push入栈，到最后栈中只有一个数。就是结果
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        int num1,num2;
        for(int i=0;i<tokens.length;i++){
            switch(tokens[i]){
                case "+":
                    num1=Integer.parseInt(stack.pop());
                    num2=Integer.parseInt(stack.pop());
                    stack.push(num2+num1+"");
                    break;
                case "-":
                    num1=Integer.parseInt(stack.pop());
                    num2=Integer.parseInt(stack.pop());
                    stack.push(num2 - num1+"");
                    break;
                case "*":
                    num1=Integer.parseInt(stack.pop());
                    num2=Integer.parseInt(stack.pop());
                    stack.push(num2 * num1+"");
                    break;
                case "/":
                    num1=Integer.parseInt(stack.pop());
                    num2=Integer.parseInt(stack.pop());
                    stack.push(num2 / num1 +"");
                    break;
                default:
                    stack.push(tokens[i]);
            }
        }
        return  Integer.parseInt(stack.pop());
    }

    /**
     * 思路二：用int[] 代替栈
     * 若后缀表达式长度是n，数字的个数最多(n+1)/2个，运算符最多(n-1)/2个
     * index表示数组的下标，默认-1，当存入一个数就++变成0
     * 若出现数字就index++ 再存入数组，若出现运算符先index-- 再把结果存入数组
     * @param tokens
     * @return
     */
    public static int evalRPN2(String[] tokens) {
        int len=tokens.length;
        int[] num_stack=new int[(len+1)/2];
        int index=-1;
        for(int i=0;i<len;i++){
            switch(tokens[i]){
                case  "+":
                    index--;
                    num_stack[index]=num_stack[index]+num_stack[index+1];
                    break;
                case "-":
                    index--;
                    num_stack[index]=num_stack[index]-num_stack[index+1];
                    break;
                case "*":
                    index--;
                    num_stack[index]=num_stack[index] * num_stack[index+1];
                    break;
                case "/":
                    index--;
                    num_stack[index]=num_stack[index] /num_stack[index+1];
                    break;
                default:
                    index++;
                    num_stack[index]=Integer.parseInt(tokens[i]);
            }
        }
        return num_stack[index];
    }
    public static  void main(String[] args){
        String[] ssss=new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(ssss));
        System.out.println(evalRPN2(ssss));
    }
}

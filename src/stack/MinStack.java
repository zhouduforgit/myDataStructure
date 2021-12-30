package stack;

import java.util.Stack;

/**
 * 力扣 面试题 03.02. 栈的最小值
 * https://leetcode-cn.com/problems/min-stack-lcci/
 * 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，
 * 还支持min函数，该函数返回栈元素中的最小值。
 * 执行push、pop和min操作的时间复杂度必须为O(1)。
 * 示例：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 思路：用2个栈来存储数据
 * 第一个 dataStack存原始数据
 * 第二个 minStack存栈中的最小值
 * 比如-2，0，-3，1进栈   dataStack -2  0 -3 1
 *                       minStack  -2 -2 -3 -3
 *  minStacj和dataStack长度一致，同增同减
 *  就能保证minStack的栈顶是最小值
 */
public class MinStack {
    Stack<Integer> dataStack;
    Stack<Integer> minStack;
    public MinStack() {
        dataStack=new Stack<>();
        minStack=new Stack<>();
    }
    public void push(int x) {
        dataStack.push(x);
        if(!minStack.isEmpty() && minStack.peek()<x){
            minStack.push(minStack.peek());
        }else {
            minStack.push(x);
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

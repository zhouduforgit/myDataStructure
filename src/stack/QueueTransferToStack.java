package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  力扣225
 *   请你仅使用两个队列实现一个后入先出（LIFO）的栈
 *   ，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
 *     实现 MyStack 类：
 *
 *     void push(int x) 将元素 x 压入栈顶。
 *     int pop() 移除并返回栈顶元素。
 *     int top() 返回栈顶元素。
 *     boolean empty() 如果栈是空的，返回 true ；否则，返回 false
 */
public class QueueTransferToStack {
    //用来存放原始数据
    Queue<Integer> dataQueue;
    //存放删除元素之前的数据。
    //比如队列dataQueue依次存放1，2，3。正常情况只能先删除1
    //现在要删除3 ，就要把1，2先poll出来放在临时队列中，在返回3
    Queue<Integer> tempQueue;
    int top; //就是最后一个入栈的元素
    public QueueTransferToStack(){
        dataQueue=new LinkedList<>();
        tempQueue=new LinkedList<>();
    }
    public void push(int x) {
        top=x;
        dataQueue.add(top);  //addLast，放入队尾相当于栈顶
    }
    public int pop() {
        while(dataQueue.size()>1) {
            int res = dataQueue.poll();//pollFirst 先进先出
            tempQueue.add(res);
        }
        Queue<Integer> temp=new LinkedList<>(); //交换dataQueue和tempQueue
        temp=dataQueue;
        dataQueue=tempQueue;
        tempQueue=temp;
        return tempQueue.poll();
    }
    public int top() {
        return top;
    }
    public boolean empty() {
        return dataQueue.size()==0;
    }

    public static void main(String[] args) {
        QueueTransferToStack qqqq=new QueueTransferToStack();
        qqqq.push(12);
        qqqq.push(32);
        qqqq.push(43);
        System.out.println(qqqq.top());
    }
}

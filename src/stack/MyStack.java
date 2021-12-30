package stack;

import java.sql.Statement;

/**
 * 此类是用数组或链表组成栈结构
 */
public class MyStack {
    int [] array;
    //top是有效元素个数
    int top=0;//若top从0开始；capacity=3；push3次后已经是top=3；超出索引范围所以pop,peek时要写array[top-1]
    int capacity;
    public MyStack(int size){
        capacity=size;
        array=new int[capacity];
    }
    public void push(int aa){
        if (isFull()) return;
        array[top++]=aa;
    }
    public int pop(){
        if (isEmpty()) return -1;
        int res=array[top-1];
        top--;
        return res;
    }
    public int peek(){
        return array[top-1];
    }
    public boolean isFull(){
        if(top>=capacity){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        return top==0;
    }

    public static void main(String[] args) {
        MyStack myStack=new MyStack(3);
        System.out.println(myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.isFull());
        System.out.println(myStack.peek());
        myStack.pop();
        myStack.pop();
        myStack.pop();
        System.out.println(myStack.isEmpty());
    }
}

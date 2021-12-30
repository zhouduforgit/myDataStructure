package stack;

import java.util.LinkedList;
import java.util.Queue;

/**用一个队列实现栈
 * 一个队列是先进先出的原则当队列已经增加1,2,3.
 * 1是最先出队了，可是在栈中3要先先出去
 * 可以先poll()队尾元素，再把此元素offer()进队尾，这样队列头部元素就是后进来的元素
 */
public class QueueTransferStack2 {
    Queue<Integer> stackQueue;
    public QueueTransferStack2(){
        stackQueue=new LinkedList<>();
    }
    public void push(int x) {
        stackQueue.add(x);
        int size=stackQueue.size();
        while(size>1){
            int head=stackQueue.poll(); //取出原来的对头
            stackQueue.offer(head); //放进队尾就变成栈结构
        }
    }
    public int top() {
        return stackQueue.peek();
    }
    public int pop() {
        return stackQueue.poll();
    }
    public boolean empty() {
        return stackQueue.size()==0;
    }
}

package queue;

/**
 * 力扣 T622
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，
 * 其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。
 * 它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。
 * 在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，
 * 我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满
 */
public class CircleQueue {
    /**
     * 思路一：队列的节点存在数组里
     * 要加入的元素有两种情况
     *    1.有size < capacity 要加入元素下标不循环
     *    原数组                   新数组        nextInsertIndex
     *    [1,2,3,0,0]    新增4   [1,2,3,4,0]           3=(head+size)%capacity=(0+3)%5
     *
     *    2. 要循环
     *    [3,0,0,1,2]    新增11  [3,11,0,1,2]          1=(3+3)%5
     *    小标从0开始
     *    nextInsertIndex=（head+size）%capacity
    */
    private int[] queue;//用数组表示环形队列
    private int capacity;//数组的总容量
    private int size ; //数组中有效元素个数le
    private int head; //队列的头节点下标

    public CircleQueue(int k) {
        capacity=k;
        queue=new int[k];
        head=0;
        size=0;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        int nextInsertIndex=(head+size)%capacity;
        queue[nextInsertIndex]=value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        head=(head+1)% capacity;
        size--;
        return true;
    }

    public int Front() {
        if(isEmpty()) return -1;
        return queue[head];
    }

    public int Rear() {
        if(isEmpty()) return -1;
        int tail=(head+size-1)%capacity;
        return queue[tail];
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==capacity;
    }
}

package queue;

public class ArrayToQueue {
    //数组最大容量
    int maxCapacity; //[1,2,3,4,5,6,7,8]
    int head=0; //队头节点 1
    int tail=0; //队尾 8
    int[] arr;
    public ArrayToQueue(int maxCapacity){
        arr=new int[maxCapacity];
        this.maxCapacity=maxCapacity;
    }
    //n是要添加的元素
    public void add(int n){
        //添加之前要判断链表是否有空闲节点
        if(isFull()==false){
            arr[tail]=n;
            tail++;
        }
    }
    public int get(){
        if(isEmpty()==false){
            int re=arr[head];
            head++;
            return  re;
        }else return -1;
    }

    public boolean isFull(){
        return tail==maxCapacity;
    }
    public boolean isEmpty(){
        return tail==head;
    }
}

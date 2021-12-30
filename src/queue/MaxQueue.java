package queue;

import java.util.LinkedList;

/**
 * 请定义一个队列并实现函数 max_value得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * 无论是队列添加或删除操作都要返回队列中最大元素
 */
public class MaxQueue {
    private LinkedList<Integer> queue;
    private LinkedList<Integer> maxQueue;
    /**
     *  初始化队列为空
     *  需要2个ArrayList存储元素，
     *  第一个存原始数组queue 第二个存队列中最大的数 maxQueue
     *  queue                              maxQueue
     *  [1]                                 [1]
     *  [1,2]                               [2]
     *  [1,2,3]  加3后，把原队列最大值覆盖了 [3]
     *  [2,3]   减1，减小的不影响           [3]
     *  [2,3,2]  加2，加入候选              [3,2] 3迟早会出队
     *  [2,3,2,1] 加1，进候选               [3,2,1]
     *  [3,2,1] 减2，减小的不影响           [3,2,1]
     *  [2,1] 减3，减去当前最大             [2,1] 3出队，此时2是最大
     *  [2,1,4] 加4，4>maxQueue所有数覆盖   [4]
     *  使用额外队列maxQueue记录最大值的变化情况
     *  maxQueue队列的首元素一直是原数组的最大值，后面加入的元素可能是候选值
     *  新增元素 ele ele< maxQueue的最大值  就把ele放在队尾
     *              ele>maxQueue的最大值  新来的元素大于maxQueue中全部，覆盖原maxQueue
     */
    public MaxQueue() {
        queue=new LinkedList<>();
        maxQueue=new LinkedList<>();
    }

    public int max_value() {
        return maxQueue.isEmpty()?-1:maxQueue.peekFirst();
    }

    //入队
    public void push_back(int value) {
        queue.offer(value);
        while(!maxQueue.isEmpty() &&value>maxQueue.peekLast()){
            //如果新元素大于maxQueue所有元素（就是依次从队尾元素比较）
            //新元素>队尾，就取出元素
            maxQueue.pollLast();
        }
        maxQueue.offerLast(value);
    }
    //出队
    public int pop_front() {
        if(maxQueue.isEmpty()) return -1;
        //在原队列queue中要删除元素 是maxQueue的最大
        assert queue.peekFirst() != null;
        if(!maxQueue.isEmpty() && queue.peekFirst().equals(maxQueue.peekFirst())){
            maxQueue.pollFirst();//就把maxQueue最大值删除
        }
        return queue.poll();
    }
}

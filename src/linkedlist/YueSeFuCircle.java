package linkedlist;

/**
 * 在一个首尾相连环形链表中，一共有n个节点，从1开始数
 * 数到第m个数，把第m个节点删了，求最后一个节点在环形链表中的位置
 */
public class YueSeFuCircle {
    /**
     *  思路 要删除第m个节点，就是让m-1个节点指向m+1个节点
     *  以第m-1个节点位基准node ; node.next=node.next.next 这就删除第m个节点
     *  引入一个变量count记录从1到m的下标。每次删除第m个节点 清零count
     *  当没有数到m，count++,node指向下一个
     * @param n 链表初始化的长度
     * @param m 从1开始数到m，删除第m个节点
     * @return
     */    public static int lookLastNodeIndex(int n,int m){
        int[] aaa=new int[n];
        for(int i=1;i<=aaa.length;i++){
            aaa[i-1]=i;
        }
        ListNode listNode=ListNode.transferToListNode(aaa);
        ListNode.toCircleList(listNode,0);
        int count=1;
        while(true){
            if(count==m-1){
                listNode.next=listNode.next.next;
                count=0;
            }
            listNode=listNode.next;
            count++;
            if(listNode.next==listNode){
                return listNode.val;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(lookLastNodeIndex(41,3));

    }
}

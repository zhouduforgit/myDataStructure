package linkedlist;


/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，
 * 它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class ListNode {
   public int val;
   public ListNode next;
   public ListNode(){}
   public ListNode(int x) {
       val = x;
   }

    /**
     * 让传输进来的int数组 转换成ListNode形式的单向链表形式
     * @param aaa
     * @return
     */
    public static ListNode transferToListNode(int[] aaa){
        if(aaa == null || aaa.length == 0) {
            return null;
        }
        //得到链表的头结点就是得到整个链表
        ListNode head = new ListNode(aaa[0]);
        // 生成当前节点 curr，让curr指向下一节点nextNode，跟新curr 让curr变成新的
        ListNode curr = head;
        for(int i=1; i<aaa.length; i++) {
            ListNode nextNode = new ListNode(aaa[i]);
            curr.next = nextNode;
            curr = nextNode;
        }
        return head;
    }

    /**
     *  单链表  1->2->3->4->5  len=5 k=2
     *  i的范围是[0,3] 当i=3时，temp=temp.next=4,从4开始
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        int ci=0;
        ListNode temp=head;
        while(temp.next!=null){
            ci++;
            temp=temp.next;
        }
        temp=head;
        for(int i=0;i<=ci-k;i++){
            temp=temp.next;
        }
        //得到某个链表的头节点就等于得到整个链表
        return temp;
    }

    public static void printList(ListNode head){
        while(head != null) {
            System.out.print(head.val);
            if(head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
    }

    /**
     * 此方法是让一个单项链表转化成一个环
     * @param head
     * @param pos 表示链表的尾节点的next指向索引
     * @return
     */
    public static  void toCircleList(ListNode head ,int pos){
        //创建变量 count 表示 遍历到第count个元素
        int count=0;
        //先得到环的入口 circleNode
        ListNode circleNode=null;
        while(true) {
            //当遍历到第pos个元素时 ，此位置count就是入口
            if(count==pos){
                circleNode=head;
            }
            //遍历在尾节点时，让尾节点的next指向入口节点
            if(head.next==null){
                head.next= circleNode;
                return;
            }
            head=head.next;
            count++;
        }
    }
    public static void main(String[] args) {
        int[] oldarr={1,2,3,4,5,6};
        ListNode listNode=transferToListNode(oldarr);
        printList(listNode);
        System.out.println();
        ListNode ll=getKthFromEnd(listNode,3);
        System.out.println(ll);
    }

    //输出一个数组的倒数第k个节点
    public static int[] transfer(int[] oldArr,int k){
        int len=oldArr.length;
        int rest=len-k;
        int[] newaaa=new int[k];
        for(int j=0;j<k;j++){
            newaaa[j]=oldArr[rest++];
        }
        return newaaa;
    }
}

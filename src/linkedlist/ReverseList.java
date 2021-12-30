package linkedlist;
/**
 * 力扣 T 206
 * 反转一个单链表。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            if(cur!=null && pre !=null){
                System.out.println("让cur："+cur.val+"指向pre-->"+pre.val);
            }
            pre=cur;
            cur=temp;
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] oldArr={1,2,34,4,5,67};
        ListNode newArr=ListNode.transferToListNode(oldArr);
        ListNode res=reverseList(newArr);
        ListNode.printList(res);
    }


    public static int[] reverseArray(int[] oldArr){
        int len=oldArr.length;
        if(len==0) return null;
        int[] newArr=new int [len];
        for(int i=0;i<len;i++){
            newArr[i]=oldArr[len-1-i];
        }
        return newArr;
    }
}

package linkedlist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，
 * 我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，
 * 并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 *
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 */
public class CircleList2 {
    public static ListNode detectCycle(ListNode head){
        ListNode pos=head;
        Set<ListNode> listNodeSet=new HashSet<>();
        while(pos!=null){
            if(listNodeSet.contains(pos)){
                return pos;
            }
            listNodeSet.add(pos);
            pos=pos.next;
        }
        return null;
    }

    /**
     * 用快慢指针 fast ,slow 初始化head
     * fast每次走2格，slow每次是1格
     * 当fast和slow相遇，记录相遇节点
     * 此时fast回到原来头节点 ，slow沿着环的路线走，并且此时fast，slow每次走一格
     * 当第二次相遇时就是环的入口节点
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head){
        if(head==null || head.next==null){
            return null;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(true){
            if(fast==null || fast.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) break;
        }
        fast=head;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        int[] aaa={1,2,3,45,65,32,41,77};
        ListNode listNode= ListNode.transferToListNode(aaa);
        ListNode.toCircleList(listNode,2);
        System.out.println(detectCycle(listNode).val);
        System.out.println("===============");
        System.out.println(detectCycle2(listNode).val);
    }
}
